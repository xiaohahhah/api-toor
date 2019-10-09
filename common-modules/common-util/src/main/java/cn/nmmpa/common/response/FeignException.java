package cn.nmmpa.common.response;

import cn.nmmpa.common.exception.BaseException;

/**
 * @Author: tan shuai
 * @Date: 2019/6/28 9:04
 * @Version 1.0
 */
public class FeignException extends BaseException {


    public FeignException(int code, String message) {
        super(code, message);
    }

    public FeignException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
