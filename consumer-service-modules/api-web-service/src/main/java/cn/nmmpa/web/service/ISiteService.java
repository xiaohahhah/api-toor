package cn.nmmpa.web.service;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.web.vo.LoginReqVo;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 16:43
 * @Version 1.0
 */
public interface ISiteService {

    /**
     * 站点登陆
     * @param loginReqVo
     * @return
     */
    ResultEntity<SiteLoginRespVo> login(LoginReqVo loginReqVo) throws Exception;
}
