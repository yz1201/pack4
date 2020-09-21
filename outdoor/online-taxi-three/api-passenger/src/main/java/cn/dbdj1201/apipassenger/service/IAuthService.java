package cn.dbdj1201.apipassenger.service;

import cn.dbdj1201.internalcommon.dto.ResponseResult;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 16:29
 */
public interface IAuthService {

     ResponseResult auth(String passengerPhone, String code);
}
