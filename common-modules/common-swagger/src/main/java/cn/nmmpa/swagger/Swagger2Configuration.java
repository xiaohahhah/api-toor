package cn.nmmpa.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * Swagger2Configuration
 *
 * @author liufeihua
 * @date 2017/12/5 17:08
 */
@Configuration
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
@Import({
        Swagger2DocumentationConfiguration.class,
        BeanValidatorPluginsConfiguration.class
})
public class Swagger2Configuration {
}
