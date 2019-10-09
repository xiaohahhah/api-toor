package cn.nmmpa.common.exception;

import cn.nmmpa.common.exception.BaseException;
import cn.nmmpa.common.response.ExceptionEnum;

/**
 * @Author: tan shuai
 * @Date: 2019/7/30 10:49
 * @Version 1.0
 */
public class ConsumerServiceException extends BaseException {


    public ConsumerServiceException(int code, String message) {
        super(code, message);
    }

    public ConsumerServiceException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
