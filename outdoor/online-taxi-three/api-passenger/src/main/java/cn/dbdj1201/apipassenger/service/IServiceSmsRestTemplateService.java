package cn.dbdj1201.apipassenger.service;

import cn.dbdj1201.internalcommon.dto.ResponseResult;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 16:14
 */
public interface IServiceSmsRestTemplateService {

    /**
     * 发送短信服务远程调用
     * @param phoneNumber
     * @param code
     * @return
     */
    ResponseResult sendSms(String phoneNumber , String code);

}
