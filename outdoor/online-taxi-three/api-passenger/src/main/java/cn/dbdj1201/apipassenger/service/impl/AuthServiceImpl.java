package cn.dbdj1201.apipassenger.service.impl;

import cn.dbdj1201.apipassenger.service.IAuthService;
import cn.dbdj1201.apipassenger.service.IServicePassengerUserService;
import cn.dbdj1201.apipassenger.service.IServiceVerificationCodeRestTemplateService;
import cn.dbdj1201.internalcommon.constant.CommonStatusEnum;
import cn.dbdj1201.internalcommon.constant.IdentityConstant;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 16:29
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private IServicePassengerUserService passengerUserService;

    @Override
    public ResponseResult auth(String passengerPhone, String code) {

        /*
        验证码校验
         */
        ResponseResult responseResult = this.serviceVerificationCodeRestTemplateService.verifyCode(IdentityConstant.PASSENGER, passengerPhone, code);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()) {
            return ResponseResult.fail("登录失败：验证码校验失败");
        }

        /*
        用户登录
         */
        responseResult = this.passengerUserService.login(passengerPhone);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()) {
            return ResponseResult.fail("登录失败：登录失败");
        }
        return responseResult;
    }
}
