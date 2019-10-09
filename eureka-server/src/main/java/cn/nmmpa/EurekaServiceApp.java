package cn.nmmpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: tan shuai
 * @Date: 2019/7/30 13:39
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApp.class,args);
    }
}
