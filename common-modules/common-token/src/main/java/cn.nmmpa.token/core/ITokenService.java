package cn.nmmpa.token.core;

import cn.nmmpa.token.vo.BaseBody;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:37
 * @Version 1.0
 */
public interface ITokenService {

    /**
     * 创建token
     * @param body
     */
    String createToken(BaseBody body) throws Exception;

    /**
     * 获取body 参数
     * @param token
     * @return
     */
    BaseBody getBody(String token) throws Exception;

    /**
     * 设置前缀
     * @param prefix
     */
    TokenService setPrefix(String prefix);

    /**
     * 获取前缀
     */
    String getPrefix();

}
