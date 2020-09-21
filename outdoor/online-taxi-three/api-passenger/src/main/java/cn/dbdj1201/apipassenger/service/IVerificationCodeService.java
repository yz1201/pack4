package cn.dbdj1201.apipassenger.service;

import cn.dbdj1201.internalcommon.dto.ResponseResult;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 9:39
 */
public interface IVerificationCodeService {


    ResponseResult send(String phoneNumber);
}
