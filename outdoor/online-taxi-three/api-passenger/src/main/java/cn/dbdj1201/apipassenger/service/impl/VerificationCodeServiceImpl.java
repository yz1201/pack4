package cn.dbdj1201.apipassenger.service.impl;

import cn.dbdj1201.apipassenger.service.IServiceSmsRestTemplateService;
import cn.dbdj1201.apipassenger.service.IServiceVerificationCodeRestTemplateService;
import cn.dbdj1201.apipassenger.service.IVerificationCodeService;
import cn.dbdj1201.internalcommon.constant.CommonStatusEnum;
import cn.dbdj1201.internalcommon.constant.IdentityConstant;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.serviceverificationcode.response.VerifyCodeResponse;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 9:39
 */
@Service
@Slf4j
public class VerificationCodeServiceImpl implements IVerificationCodeService {

    @Autowired
    private IServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private IServiceSmsRestTemplateService serviceSmsRestTemplateService;

    @Override
    public ResponseResult send(String phoneNumber) {
        ResponseResult result = this.serviceVerificationCodeRestTemplateService.generateCode(IdentityConstant.PASSENGER, phoneNumber);
        VerifyCodeResponse response;
        /*
        远程调用，获取验证码
         */
        if (result.getCode() == CommonStatusEnum.SUCCESS.getCode()) {
            Assert.notNull(result.getData(), "传空值？");
            response = (VerifyCodeResponse) JSONObject.parse((String) result.getData());
        } else {
            return ResponseResult.fail("获取验证码失败");
        }

        /*
        发送验证码到客户端
         */
        ResponseResult responseResult = this.serviceSmsRestTemplateService.sendSms(phoneNumber, response.getCode());

        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()) {
            return ResponseResult.fail("短信发送失败");
        }

        return ResponseResult.success("");
    }


}
