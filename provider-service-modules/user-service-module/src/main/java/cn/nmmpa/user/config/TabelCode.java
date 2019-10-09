package cn.nmmpa.user.config;

/**
 * @Author: tan shuai
 * @Date: 2019/8/28 16:40
 * @Version 1.0
 */
public enum TabelCode {

    USER("用户")
    ;

    TabelCode(String msg) {
        this.msg = msg;
    }


    private String msg;

    public String getMsg() {
        return msg;
    }}
