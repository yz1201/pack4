package cn.dbdj1201.apipassenger.controller;

import cn.dbdj1201.apipassenger.request.UserAuthRequest;
import cn.dbdj1201.apipassenger.service.IAuthService;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-20 9:18
 */
@RestController
@RequestMapping("/auth/")
@Slf4j
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Validated UserAuthRequest userAuthRequest) {
        log.info("login user -{}", userAuthRequest);
        String passengerPhone = userAuthRequest.getPassengerPhone();
        String code = userAuthRequest.getCode();
        return this.authService.auth(passengerPhone, code);

    }
}
