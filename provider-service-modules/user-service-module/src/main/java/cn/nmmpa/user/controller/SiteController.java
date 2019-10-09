package cn.nmmpa.user.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.model.Site;
import cn.nmmpa.user.service.ISiteService;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.user.vo.SiteSecretVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mister Tan
 * Created by TS on 2019/8/26.
 */
@RestController
@RequestMapping("/site")
@Api(description = "站点")
public class SiteController {

    @Autowired
    private ISiteService siteService;

    @ApiOperation("站点登陆")
    @GetMapping("/login")
    public ResultEntity<SiteLoginRespVo> login(@RequestParam String account,
                                               @RequestParam String passWord) throws Exception {
        return ResultEntity.success(siteService.login(account , passWord));
    }

    @ApiOperation("查看appId和Secret")
    @GetMapping("/secret/{siteCode}")
    public ResultEntity<SiteSecretVo> getSecret(@PathVariable("siteCode") String siteCode) throws Exception {
        return ResultEntity.success(siteService.getSecret(siteCode));
    }

    @ApiOperation("根据具体条件查询站点信息")
    @PostMapping("/queryConditionsToObject")
    public ResultEntity<Site> queryConditionsToObject(@RequestBody Site site) throws Exception{
        site = siteService.queryConditionsToObject(site);
        site.setPassWord(null);
        return ResultEntity.success(site);
    }

}
