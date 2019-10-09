package cn.nmmpa.web.service.impl;

import cn.nmmpa.common.response.FeignUtil;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.common.util.EncryptUtil;
import cn.nmmpa.user.api.SiteFeign;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.web.service.ISiteService;
import cn.nmmpa.web.vo.LoginReqVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 17:13
 * @Version 1.0
 */
@Service
public class SiteServiceImpl implements ISiteService {

    @Resource
    private SiteFeign siteFeign;

    @Override
    public ResultEntity<SiteLoginRespVo> login(LoginReqVo loginReqVo) throws Exception {
        EncryptUtil.checkSign(loginReqVo);
        ResultEntity<SiteLoginRespVo> login =
                siteFeign.login(loginReqVo.getAccount(), loginReqVo.getPassWord());
        FeignUtil.checkResp(login);
        return login;
    }
}
