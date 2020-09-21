package cn.dbdj1201.servicesms.controller;

import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.servicesms.request.SmsSendRequest;
import cn.dbdj1201.servicesms.service.ISmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 10:09
 */
@RestController
@RequestMapping("/send")
@Slf4j
public class SendController {


    @Autowired
    private ISmsService smsService;

    @PostMapping("/sms-template")
    public ResponseResult send(@RequestBody SmsSendRequest smsSendRequest) {
        return this.smsService.sendSms(smsSendRequest);
    }
}
