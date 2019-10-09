package cn.nmmpa.common.exception;

import cn.nmmpa.common.response.ExceptionEnum;
import lombok.Data;

/**
 * @Author: tan shuai
 * @Date: 2019/6/28 9:04
 * @Version 1.0
 */
 @Data
public class BaseException extends RuntimeException{

    private int code;

    public BaseException(int code , String message) {
        super(message);
        this.code = code;
    }

    public BaseException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.message());
        this.code = exceptionEnum.code();
    }
}
