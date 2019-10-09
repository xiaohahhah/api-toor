package cn.nmmpa.aop.formvalidation;

import cn.nmmpa.common.exception.BaseException;
import cn.nmmpa.common.response.ExceptionEnum;

/**
 * @Author: tan shuai
 * @Date: 2019/8/1 15:45
 * @Version 1.0
 */
public class RequestLimitException extends BaseException {

    public RequestLimitException(int code, String message) {
        super(code, message);
    }

    public RequestLimitException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
