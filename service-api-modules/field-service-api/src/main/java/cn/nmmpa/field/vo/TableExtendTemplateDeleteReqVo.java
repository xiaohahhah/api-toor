package cn.nmmpa.field.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by TS on 2019/8/28.
 */
@Data
public class TableExtendTemplateDeleteReqVo {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("站点code")
    private String siteCode;

    @ApiModelProperty("表code")
    private String tableCode;
}
