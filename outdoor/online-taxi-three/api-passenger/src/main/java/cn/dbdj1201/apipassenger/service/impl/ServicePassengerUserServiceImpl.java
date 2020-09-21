package cn.dbdj1201.apipassenger.service.impl;

import cn.dbdj1201.apipassenger.service.IServicePassengerUserService;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.servicepassengeruser.request.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 16:36
 */
@Service
@Slf4j
public class ServicePassengerUserServiceImpl implements IServicePassengerUserService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseResult login(String passengerPhone) {
        String url = "http://SERVICE-PASSENGER-USER/auth/login";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassengerPhone(passengerPhone);
        return restTemplate.exchange(url, HttpMethod.POST,
                new HttpEntity<Object>(loginRequest, null),
                ResponseResult.class).getBody();
    }
}
