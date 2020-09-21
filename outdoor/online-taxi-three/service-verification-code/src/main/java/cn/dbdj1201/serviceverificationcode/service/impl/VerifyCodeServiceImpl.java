package cn.dbdj1201.serviceverificationcode.service.impl;

import cn.dbdj1201.internalcommon.constant.CommonStatusEnum;
import cn.dbdj1201.internalcommon.constant.IdentityConstant;
import cn.dbdj1201.internalcommon.constant.RedisKeyPrefixConstant;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.serviceverificationcode.response.VerifyCode;
import cn.dbdj1201.internalcommon.util.RedisUtils;
import cn.dbdj1201.serviceverificationcode.service.IVerifyCodeService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.stereotype.Service;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-18 15:29
 */
@Service
@Slf4j
public class VerifyCodeServiceImpl implements IVerifyCodeService {

    @Autowired
    private RedisUtils redisUtils;

    private static final String USER_MIN_KEY = "TAXI:DBDJ1201:MIN:";
    private static final String USER_HOUR_KEY = "TAXI:DBDJ1201:HOUR:";
    private static final int DEFAULT_MIN_THRESHOLD = 3;
    private static final int DEFAULT_HOUR_THRESHOLD = 10;
    private static final String DEFAULT_DELIMITER = ":";

    @Override
    public ResponseResult generateVerificationCode(Integer identity, String phoneNumber) {
        /*
        验证码发送限制，不能无限发短信，保存在redis中的带时限的验证码
            一分钟内发了3次不能再发，一小时10次，24小时内不让发
         */

        String minKey = USER_MIN_KEY + identity + DEFAULT_DELIMITER + phoneNumber;
        String hourKey = USER_HOUR_KEY + identity + DEFAULT_DELIMITER + phoneNumber;
        if (shouldLimitAtLastMin(minKey)) {
            return new ResponseResult<VerifyCode>().setCode(CommonStatusEnum.VERIFICATION_ONE_MIN_ERROR.getCode())
                    .setMessage(CommonStatusEnum.VERIFICATION_ONE_MIN_ERROR.getValue());
        }

        if (shouldLimitAtLastHour(hourKey)) {
            return new ResponseResult<VerifyCode>().setCode(CommonStatusEnum.VERIFICATION_ONE_HOUR_ERROR.getCode())
                    .setMessage(CommonStatusEnum.VERIFICATION_ONE_HOUR_ERROR.getValue());
        }

        /*
        走到这里，说明可用发送信息，上边已经往redis里边+1了，这里必须发送。
         */
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));
        log.info("发送短信验证码-{}-time {}", code, System.currentTimeMillis());
        return ResponseResult.success(code);
    }

    /**
     * 一分钟3次限制
     *
     * @return 返回
     */
    private boolean shouldLimitAtLastMin(String minKey) {
        int minTimes = this.redisUtils.get(minKey) == null ? 0 : (int) this.redisUtils.get(minKey);

        if (minTimes >= DEFAULT_MIN_THRESHOLD) {
            return true;
        } else {
            if (minTimes == 0) {
                this.redisUtils.set(minKey, 1, 60);
            } else {
                long expire = this.redisUtils.getExpire(minKey);
                expire = expire <= 0 ? 0 : expire;
                this.redisUtils.set(minKey, minTimes + 1, expire);
            }
            return false;
        }
    }

    private boolean shouldLimitAtLastHour(String hourKey) {
        int hourTimes = this.redisUtils.get(hourKey) == null ? 0 : (int) this.redisUtils.get(hourKey);
        if (hourTimes >= DEFAULT_HOUR_THRESHOLD) {
            this.redisUtils.set(hourKey,0,0);
            return true;
        } else {
            if (hourTimes == 0) {
                this.redisUtils.set(hourKey, 1, 3600);
            } else {
                long expire = this.redisUtils.getExpire(hourKey);
                expire = expire <= 0 ? 0 : expire;
                this.redisUtils.set(hourKey, hourTimes + 1, 3600 - expire);
            }
            return false;
        }
    }



       /*
        验证码校验，不能无限发短信，保存在redis中的带时限的验证码
            一分钟内相同验证码错误达到3次，请1分钟后登录
            一小时内相同验证码错误达到3次，请一小时后登录
            一小时内验证码错误达到5次，请24小时后登录
         */

    @Override
    public ResponseResult verify(int identity,String phoneNumber,String code){
        //三档验证


        //生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        String redisCode = (String) this.redisUtils.get(key);

        if(StrUtil.isNotBlank(code)
                && StrUtil.isNotBlank(redisCode)
                && code.trim().equals(redisCode.trim())) {

            return ResponseResult.success("");
        }else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }

    }

    /**
     * 根据身份类型生成对应的缓存key
     * @param identity
     * @return
     */
    private String generateKeyPreByIdentity(int identity){
        String keyPre = "";
        if (identity == IdentityConstant.PASSENGER){
            keyPre = RedisKeyPrefixConstant.PASSENGER_LOGIN_CODE_KEY_PRE;
        }else if (identity == IdentityConstant.DRIVER){
            keyPre = RedisKeyPrefixConstant.DRIVER_LOGIN_CODE_KEY_PRE;
        }
        return keyPre;
    }


}
