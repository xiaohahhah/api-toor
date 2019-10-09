package cn.nmmpa.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @Author: tan shuai
 * @Date: 2019/8/13 13:34
 * @Version 1.0
 */
public class SexValueValidate implements ConstraintValidator<SexCheckValue, Integer> {


    private SexCheckValue appointValue;

    @Override
    public void initialize(SexCheckValue constraintAnnotation) {
        this.appointValue = constraintAnnotation;
    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s == 0){
            return true;
        }
        int[] value = appointValue.value();
        if(Arrays.asList(value).contains(s)){
            return true;
        }
        return false;
    }
}
