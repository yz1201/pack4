package cn.dbdj1201.apipassenger.controller;

import cn.dbdj1201.apipassenger.request.ShortMsgRequest;
import cn.dbdj1201.apipassenger.service.IVerificationCodeService;
import cn.dbdj1201.internalcommon.dto.ResponseResult;
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
@RequestMapping("/verify-code/")
public class VerificationCodeController {

    @Autowired
    private IVerificationCodeService verificationCodeService;


    @PostMapping("/send")
    public ResponseResult send(@RequestBody @Validated ShortMsgRequest request) {
        return verificationCodeService.send(request.getPhoneNumber());
    }
}
