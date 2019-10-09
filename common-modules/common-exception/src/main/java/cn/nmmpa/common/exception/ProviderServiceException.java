package cn.nmmpa.common.exception;

import cn.nmmpa.common.response.ExceptionEnum;

/**
 * @Author: tan shuai
 * @Date: 2019/7/30 10:48
 * @Version 1.0
 */
public class ProviderServiceException extends BaseException {

    public ProviderServiceException(int code, String message) {
        super(code, message);
    }

    public ProviderServiceException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
