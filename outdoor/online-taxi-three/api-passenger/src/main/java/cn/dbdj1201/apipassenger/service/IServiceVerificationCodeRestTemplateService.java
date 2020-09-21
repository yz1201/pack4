package cn.dbdj1201.apipassenger.service;

import cn.dbdj1201.internalcommon.dto.ResponseResult;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 9:31
 */
public interface IServiceVerificationCodeRestTemplateService {

    ResponseResult generateCode(int identity, String phoneNumber);

    ResponseResult verifyCode(int identity,String phoneNumber,String code);
}
