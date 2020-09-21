package cn.dbdj1201.serviceverificationcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cn.dbdj1201")
public class ServiceVerificationCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVerificationCodeApplication.class, args);
    }

}
