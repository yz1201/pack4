package cn.dbdj1201.apipassenger.service.impl;

import cn.dbdj1201.apipassenger.service.IServiceVerificationCodeRestTemplateService;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.serviceverificationcode.request.VerifyCodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 9:31
 */
@Service
public class ServiceVerificationCodeRestTemplateServiceImpl implements IServiceVerificationCodeRestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://service-verification-code/verify-code/generate/";

    @Override
    public ResponseResult generateCode(int identity, String phoneNumber) {
        return this.restTemplate.exchange(BASE_URL + identity + "/" + phoneNumber, HttpMethod.GET, HttpEntity.EMPTY, ResponseResult.class).getBody();
    }

    @Override
    public ResponseResult verifyCode(int identity, String phoneNumber, String code) {
        String url = "http://service-verification-code/verify-code/verify/";
        VerifyCodeRequest request = new VerifyCodeRequest();
        request.setCode(code);
        request.setIdentity(identity);
        request.setPhoneNumber(phoneNumber);
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<Object>(request, null), ResponseResult.class).getBody();
    }
}
