package cn.nmmpa.user.api.hystrix;

import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.api.SiteFeign;
import cn.nmmpa.user.model.Site;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import org.springframework.stereotype.Component;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 17:35
 * @Version 1.0
 */
@Component
public class SiteHystrix implements SiteFeign {

    @Override
    public ResultEntity<SiteLoginRespVo> login(String account, String passWord) throws Exception {
        return ResultEntity.error(ExceptionEnum.HYSTRIX);
    }

    @Override
    public ResultEntity<Site> queryConditionsToObject(Site site) throws Exception {
        return ResultEntity.error(ExceptionEnum.HYSTRIX);
    }
}
