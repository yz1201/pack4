package cn.dbdj1201.apipassenger.service.impl;

import cn.dbdj1201.apipassenger.service.IServiceSmsRestTemplateService;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.servicesms.SmsTemplateDto;
import cn.dbdj1201.internalcommon.dto.servicesms.request.SmsSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 16:15
 */
@Service
public class ServiceSmsRestTemplateServiceImpl implements IServiceSmsRestTemplateService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseResult sendSms(String phoneNumber, String code) {

        /*
        远程调用地址
         */
        String http = "http://";
        String serviceName = "SERVICE-SMS";
        String uri = "/send/sms-template";

        /*
        发起远程调用
         */

        String url = http + serviceName + uri;
        SmsSendRequest smsSendRequest = new SmsSendRequest();
        String[] phoneNumbers = new String[]{phoneNumber};
        smsSendRequest.setReceivers(phoneNumbers);

        List<SmsTemplateDto> data = new ArrayList<>();
        SmsTemplateDto dto = new SmsTemplateDto();
        //这个id是怎么生成的？阿里云申请的固定消息的模板，跟那些key一样可用设置成工程的配置参数项，在yml文件中配置
        dto.setId("SMS_144145499");

        int templateSize = 1;
        HashMap<String, Object> templateMap = new HashMap<>(templateSize);
        templateMap.put("code", code);
        dto.setTemplateMap(templateMap);
        data.add(dto);
        smsSendRequest.setData(data);
        return restTemplate.postForEntity(url, smsSendRequest, ResponseResult.class).getBody();
    }
}
