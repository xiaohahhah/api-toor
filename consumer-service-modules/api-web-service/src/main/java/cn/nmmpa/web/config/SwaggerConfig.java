package cn.nmmpa.web.config;

import cn.nmmpa.swagger.SawaggerBase;
import cn.nmmpa.swagger.SwaggerBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 17:53
 * @Version 1.0
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket siteDocket(){
        SwaggerBean swaggerBean = new SwaggerBean();
        swaggerBean.setIsToken(false);
        swaggerBean.setTitle("API后台管理");
        swaggerBean.setVersion("1.0.0");
        swaggerBean.setBasePackage("cn.nmmpa.web.controller");
        return SawaggerBase.createRestApi(swaggerBean);
    }
}
