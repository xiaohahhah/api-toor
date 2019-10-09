package cn.nmmpa.field.model;

import cn.nmmpa.common.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author TanShuai
 * @version 1.0 2019年8月29日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "拓展字段")
@Accessors(chain = true)
public class ExtendFields extends BaseModel {

    @ApiModelProperty("字段名")
    private String field;
    @ApiModelProperty("值")
    private String value;
    @ApiModelProperty("用户code")
    private String userCode;
    @ApiModelProperty("表code")
    private String tableCode;

}