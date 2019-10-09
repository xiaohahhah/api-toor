package cn.nmmpa.aop.formvalidation;

import cn.nmmpa.common.exception.BaseException;
import cn.nmmpa.common.response.ExceptionEnum;

/**
 * @Author: tan shuai
 * @Date: 2019/8/1 10:48
 * @Version 1.0
 */
public class FormValidationException extends BaseException {

    public FormValidationException(int code, String message) {
        super(code, message);
    }

    public FormValidationException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
