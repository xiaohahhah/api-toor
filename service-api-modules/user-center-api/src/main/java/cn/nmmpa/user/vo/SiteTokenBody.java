package cn.nmmpa.user.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tan
 * Created by TS on 2019/8/26.
 */
@Data
@Accessors(chain = true)
public class SiteTokenBody {

    private String siteCode;

}
