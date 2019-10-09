package cn.nmmpa.field.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: tan shuai
 * @Date: 2019/8/28 16:02
 * @Version 1.0
 */
@Data
public class TableExtendTemplateAddReqVo {

    @ApiModelProperty("站点")
    private String siteCode;
    @ApiModelProperty("字段")
    private String field;
    @ApiModelProperty("字段描述")
    private String describe;
    @ApiModelProperty("扩展表code")
    private String tableCode;
}
