package cn.nmmpa.shiro;



import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lhm
 * @date 2019/10/17 11:06
 **/
@SpringBootApplication
@EnableSwagger2Doc
@ComponentScan(basePackages = {"cn.nmmpa"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTransactionManagement
@MapperScan("cn.nmmpa.shiro.mapper")
public class ShiroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroServiceApplication.class,args);
    }
}

