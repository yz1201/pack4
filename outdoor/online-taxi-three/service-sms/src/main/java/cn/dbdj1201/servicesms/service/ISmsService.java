package cn.dbdj1201.servicesms.service;

import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.servicesms.request.SmsSendRequest;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 10:11
 */
public interface ISmsService {

    ResponseResult sendSms(SmsSendRequest smsSendRequest);
}
