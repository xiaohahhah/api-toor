package cn.nmmpa.shiro.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.nmmpa.common.base.model.BaseModel;

/**
 * @author TanShuai
 * @version 1.0 2019年10月25日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "资源表")
@TableName("permission")
public class Permission extends BaseModel {

    @ApiModelProperty("资源名称")
    private String name;
    @ApiModelProperty("权限代码字符串")
    private String perCode;

}