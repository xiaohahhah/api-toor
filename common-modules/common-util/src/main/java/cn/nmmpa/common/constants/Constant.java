package cn.nmmpa.common.constants;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 14:08
 * @Version 1.0
 */
public class Constant {

    /**
     * 手机正则
     */
    public static final String TEL_REGEXP = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * 性别男
     */
    public static final int SEX_MALE = 1;

    /**
     * 性别女
     */
    public static final int SEX_FAMALE = 2;

    /**
     * 用户禁用状态
     */
    public static final Integer USER_DISENABLE_STATE = 1;

    /**
     * 用户启用状态
     */
    public static final int USER_ENABLE_STATE = 0;
}
