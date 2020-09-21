package cn.dbdj1201.cloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yz1201
 * @date
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
    }

}
