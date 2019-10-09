package cn.nmmpa.common.exception;

import cn.nmmpa.common.response.ExceptionEnum;

/**
 * @Author: tan shuai
 * @Date: 2019/8/28 20:37
 * @Version 1.0
 */
public class AssertUtil {

    /**
     * 验证字符串非空
     * @param param
     * @param msg
     */
    public static void isNotNull(String param , String msg){
        if(null == param || "".equals(param)){
            throw new ProviderServiceException(ExceptionEnum.PARAM_ERROR.setMessage(msg));
        }
    }
}
