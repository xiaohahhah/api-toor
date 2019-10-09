package cn.nmmpa.common.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author: tan shuai
 * @Date: 2019/8/13 11:41
 * @Version 1.0
 */

@Constraint(validatedBy = { SexValueValidate.class })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface SexCheckValue {

    int[] value() default {};

    String message() default "不是指定参数值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
