package cn.nmmpa.common.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Mister Tan
 * @date 2018/9/15
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {


    SUCCESS(200 , "操作成功"),

    ERROR(500 , "操作失败"),

    PARAM_ERROR(400 , "参数错误"),

    DELETE_ERROR(203 , "删除失败"),

    ACCOUNT_OR_PWD_ERROR(403, "账户或密码错误"),

    HYSTRIX(204 , "网络连接失败，请重试!"),

    TEL_EXISTENCE(205 , "手机号已存在"),

    USER_DISENABLE(206 , "用户被禁用")
    ;
    int code;
    String message;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public ExceptionEnum setValue(int code) {
        this.code = code;
        return this;
    }

    public ExceptionEnum setMessage(String message) {
        this.message = message;
        return this;
    }


}
