package cn.nmmpa.swagger;

import com.google.common.base.Predicates;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 15:45
 * @Version 1.0
 */
public class SawaggerBase {

    /**
     * 配置header头
     * @return
     */
    public static List<Parameter> apiTokenHeaders(){
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token")
                .description("令牌(登录后获取令牌)")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        return pars;
    }

    /**
     * 获取文档对象
     * @return
     */
    public static Docket createRestApi(SwaggerBean swaggerBean) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
            // TODO 如果是线上环境，添加路径过滤，设置为全部都不符合
//                 .paths(PathSelectors.none())
            //错误路径不监控
                 .paths(Predicates.not(PathSelectors.regex("/error.*")))
            // 对根下所有路径进行监控
//                 .paths(PathSelectors.regex("/.*"))
                 .apis(RequestHandlerSelectors.basePackage(swaggerBean.getBasePackage()))
                 .build()
                 .globalOperationParameters(swaggerBean.getIsToken() ? apiTokenHeaders() : new ArrayList<>())
                 .apiInfo(new ApiInfoBuilder()
                         .title(swaggerBean.getTitle())
                         .version(swaggerBean.getVersion()) .build());
        return docket;
    }
}
