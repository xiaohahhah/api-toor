package cn.nmmpa.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 15:59
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.nmmpa"})
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class,args);
    }
}
