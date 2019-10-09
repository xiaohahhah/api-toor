package cn.nmmpa.user.api;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.model.Site;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 17:33
 * @Version 1.0
 */
@FeignClient(value = "USER-SERVICE-MODULE")
public interface SiteFeign {

    /**
     * 站点登陆
     * @param account
     * @param passWord
     * @return
     * @throws Exception
     */
    @GetMapping("/site/login")
    ResultEntity<SiteLoginRespVo> login(@RequestParam("account") String account,
                                        @RequestParam("passWord") String passWord) throws Exception;

    /**
     * 根据具体条件查询站点信息
     * @param site
     * @return
     * @throws Exception
     */
    @PostMapping("/site/queryConditionsToObject")
    ResultEntity<Site> queryConditionsToObject(@RequestBody Site site) throws Exception;

}
