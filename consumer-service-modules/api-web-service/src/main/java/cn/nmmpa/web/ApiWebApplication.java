package cn.nmmpa.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: tan shuai
 * @Date: 2019/7/31 15:14
 * @Version 1.0
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"cn.nmmpa"})
@ComponentScan(basePackages = {"cn.nmmpa"})
public class ApiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class , args);
    }
}
