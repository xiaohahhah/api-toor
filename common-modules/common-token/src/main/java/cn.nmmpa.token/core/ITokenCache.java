package cn.nmmpa.token.core;

import cn.nmmpa.token.vo.BaseBody;


/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:02
 * @Version 1.0
 */
public interface ITokenCache {

    /**
     *
     * @param key
     * @param token
     */
   void setToken(String key , String token);

    /**
     * 获取token
     * @param key
     * @return
     */
   String getToken(String key);

    /**
     * 刷新token时间
     * @param key
     */
   void refreshTime(String key);

    /**
     * 创建redis key
     * @param key
     * @param prefix
     * @return
     */
   String createRedisKey(String key , String prefix);

    /**
     * 设置时间
     * @param time
     * @return
     */
   ITokenCache setRefreshTime(Long time);

}
