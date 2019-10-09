package cn.nmmpa.field.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.field.model.BaseExtendFields;
import cn.nmmpa.field.service.IExtendFieldsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author lhm
 * @date 2019/8/29 18:13
 **/
@RestController
@RequestMapping("/extendFields")
@Api(description = "拓展字段")
public class ExtendFieldsController {

    @Autowired
    private IExtendFieldsService extendFieldsService;

    @ApiModelProperty("查询当前用扩展字段")
    @GetMapping("/getFields")
    public ResultEntity<Map<String, String>> getFields(@RequestParam("userCode") String userCode,
                                                       @RequestParam("tableCode") String tableCode ,
                                                       @RequestParam("siteCode") String siteCode) {
        return ResultEntity
                .success(extendFieldsService.getFields(userCode , tableCode , siteCode));
    }

    @ApiModelProperty("对应用户新增扩展字段")
    @PostMapping("/addExtendFields")
    public ResultEntity addExtendFields(@RequestBody BaseExtendFields extendFields,
                                        @RequestParam("userCode") String userCode,
                                        @RequestParam("tableCode") String tableCode,
                                        @RequestParam("siteCode") String siteCode){
        extendFieldsService.addExtendFields(extendFields , userCode , tableCode , siteCode);
        return ResultEntity.success();
    }
}
