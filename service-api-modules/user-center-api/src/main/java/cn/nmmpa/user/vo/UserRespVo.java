package cn.nmmpa.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by TS on 2019/8/28.
 */
@Data
public class UserRespVo implements Serializable{

    @ApiModelProperty("用户code")
    private String userCode;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("电话")
    private String tel;
    @ApiModelProperty("注册时间")
    private java.util.Date registerTime;
    @ApiModelProperty("扩展字段")
    private Map<String , String> extendFields;

}
