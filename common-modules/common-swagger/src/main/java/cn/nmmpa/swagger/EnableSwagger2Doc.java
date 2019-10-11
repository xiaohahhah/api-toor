package cn.nmmpa.swagger;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableSwagger2Doc
 *
 * @author liufeihua
 * @date 2017/12/5 17:07
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableSwagger2Doc {
}
