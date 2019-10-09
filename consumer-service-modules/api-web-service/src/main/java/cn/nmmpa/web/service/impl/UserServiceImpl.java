package cn.nmmpa.web.service.impl;

import cn.nmmpa.common.exception.ConsumerServiceException;
import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.response.FeignUtil;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.common.util.EncryptUtil;
import cn.nmmpa.user.api.SiteFeign;
import cn.nmmpa.user.api.UserFeign;
import cn.nmmpa.user.model.Site;
import cn.nmmpa.user.model.User;
import cn.nmmpa.web.service.IUserService;
import cn.nmmpa.web.vo.UserRegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 10:01
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private SiteFeign siteFeign;
    @Resource
    private UserFeign userFeign;

    @Override
    public ResultEntity userRegister(UserRegisterVo userRegisterVo) throws Exception {
        //数据验签
        EncryptUtil.checkSign(userRegisterVo);
        //根据appId查询对应站点信息
        Site site = new Site();
        site.setAppId(userRegisterVo.getAppId());
        site.setSecretKey(userRegisterVo.getSecretKey());
        ResultEntity<Site> siteResultEntity = siteFeign.queryConditionsToObject(site);
        Site data = FeignUtil.getData(siteResultEntity);
        //判断站点信息
        if(data == null){
            throw new ConsumerServiceException(
                    ExceptionEnum.PARAM_ERROR.setMessage("appId或secretKey错误"));
        }
        User user = new User();
        BeanUtils.copyProperties(userRegisterVo , user);
        user.setSiteCode(data.getSiteCode());
        //判断是否有用户名没有的话，默认手机号
        user.setUserName(StringUtils.isEmpty(user.getUserName()) ? user.getTel() : user.getUserName());
        //验证是否调用成
        FeignUtil.checkResp(userFeign.add(user));
        return ResultEntity.success();
    }
}
