package cn.nmmpa.field;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lhm
 * @date 2019/8/29 17:43
 **/
@SpringCloudApplication
@ComponentScan(basePackages = {"cn.nmmpa"})
public class FieldServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FieldServiceApplication.class,args);
    }
}
