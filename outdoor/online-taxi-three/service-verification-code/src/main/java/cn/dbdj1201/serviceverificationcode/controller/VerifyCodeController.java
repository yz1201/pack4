package cn.dbdj1201.serviceverificationcode.controller;

import cn.dbdj1201.internalcommon.dto.ResponseResult;
import cn.dbdj1201.internalcommon.dto.serviceverificationcode.request.VerifyCodeRequest;
import cn.dbdj1201.internalcommon.dto.serviceverificationcode.response.VerifyCode;
import cn.dbdj1201.internalcommon.dto.serviceverificationcode.response.VerifyCodeResponse;
import cn.dbdj1201.serviceverificationcode.service.IVerifyCodeService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-09-18 13:47
 */
@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {
    public static void main(String[] args) {
        int len = 1000000;
        TimeInterval timer = DateUtil.timer();
        for (int i = 0; i < len; i++) {
            String code = (Math.random() + "").substring(2, 8);
        }

        System.out.println(timer.intervalRestart());

        for (int i = 0; i < len; i++) {
            String code = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));
        }
        System.out.println(timer.intervalRestart());

        for (int i = 0; i < len; i++) {
            String code = RandomUtil.randomNumbers(6);
        }
        System.out.println(timer.intervalRestart());
    }

    @Autowired
    private IVerifyCodeService verifyCodeService;

    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult<VerifyCodeResponse> generate(
            @PathVariable("identity") Integer identity,
            @PathVariable("phoneNumber") String phoneNumber
    ) {
        log.info("call user - {} {}", identity, phoneNumber);
        return this.verifyCodeService.generateVerificationCode(identity,phoneNumber);
    }

    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody VerifyCodeRequest request) {
        log.info("/verify-code/verify  request:"+ JSONObject.toJSONString(request));
        //获取手机号和验证码
        String phoneNumber = request.getPhoneNumber();
        int identity = request.getIdentity();
        String code = request.getCode();

        return verifyCodeService.verify(identity,phoneNumber,code);

    }


}
