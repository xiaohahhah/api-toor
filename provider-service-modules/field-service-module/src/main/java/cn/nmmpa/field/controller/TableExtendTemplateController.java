package cn.nmmpa.field.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.field.service.ITableExtendTemplateService;
import cn.nmmpa.field.vo.TableExtendTemplateAddReqVo;
import cn.nmmpa.field.vo.TableExtendTemplateDeleteReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/8/28 17:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/tableExtendTemplate")
@Api(description = "表字段扩展")
public class TableExtendTemplateController {

    @Autowired
    private ITableExtendTemplateService tableExtendTemplateService;

    @ApiOperation("新增字段")
    @PostMapping("/add")
    public ResultEntity add(@RequestBody TableExtendTemplateAddReqVo templateAddReqVo){
        tableExtendTemplateService.add(templateAddReqVo);
        return ResultEntity.success();
    }

    @ApiOperation("获取当前表扩展字段")
    @GetMapping("/selectByFields")
    public ResultEntity<List<String>> selectByFields(@RequestParam String siteCode,
                                                     @RequestParam String tableCode){
        return ResultEntity
                .success(tableExtendTemplateService.selectByFields(siteCode , tableCode));
    }

    @ApiModelProperty("按id删除扩展字段")
    @PostMapping("/deleteById")
    public ResultEntity deleteById(@RequestBody TableExtendTemplateDeleteReqVo templateDeleteReqVo){
        tableExtendTemplateService.deleteById(templateDeleteReqVo);
        return ResultEntity.success();
    }
}
