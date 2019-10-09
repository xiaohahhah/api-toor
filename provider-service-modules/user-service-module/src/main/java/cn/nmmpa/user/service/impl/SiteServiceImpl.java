package cn.nmmpa.user.service.impl;

import cn.nmmpa.common.exception.ProviderServiceException;
import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.common.util.RegexUtil;
import cn.nmmpa.token.core.Authorize;
import cn.nmmpa.token.vo.BaseBody;
import cn.nmmpa.user.model.Site;
import cn.nmmpa.user.service.ISiteService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.user.vo.SiteSecretVo;
import cn.nmmpa.user.vo.SiteTokenBody;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.user.mapper.SiteMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
@Service
public class SiteServiceImpl extends BaseServiceImpl<SiteMapper , Site> implements ISiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Autowired
    private Authorize authoriz;

    @Override
    public SiteMapper getMapper(){ 
       return siteMapper;
    }

    @Override
    public SiteLoginRespVo login(String account, String passWord) throws Exception {
        Site site = new Site();
        //判断登陆方式
        if(RegexUtil.isAccount(account)){
            site.setAccount(account);
            site = siteMapper.queryConditionsToObject(site);
        }else {
            site.setTel(account);
            site = siteMapper.queryConditionsToObject(site);
        }
        String pwd = MD5Util.MD5(new StringBuffer(passWord).append(site.getSalt()).toString());
        //账户或密码错误
        if(site == null || !pwd.equals(site.getPassWord())){
            throw new ProviderServiceException(ExceptionEnum.ACCOUNT_OR_PWD_ERROR);
        }
        BaseBody<SiteTokenBody> baseBody = new BaseBody<>();
        baseBody.setBody(new SiteTokenBody());
        baseBody.getBody().setSiteCode(site.getSiteCode());
        baseBody.setKey(site.getId().toString());
        SiteLoginRespVo siteLoginRespVo = new SiteLoginRespVo();
        BeanUtils.copyProperties(site , siteLoginRespVo);
        String token = authoriz.createToken(baseBody);
        siteLoginRespVo.setToken(token);
        return siteLoginRespVo;
    }

    @Override
    public SiteSecretVo getSecret(String siteCode) throws Exception {
        Site site = new Site();
        site.setSiteCode(siteCode);
        SiteSecretVo siteSecretVo = new SiteSecretVo();
        BeanUtils.copyProperties(siteMapper.queryConditionsToObject(site) , siteSecretVo);
        return siteSecretVo;
    }
}