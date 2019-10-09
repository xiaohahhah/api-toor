package cn.nmmpa.field.api.hystrix;

import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.field.api.TableExtendTemplateFeign;
import cn.nmmpa.field.vo.TableExtendTemplateAddReqVo;
import cn.nmmpa.field.vo.TableExtendTemplateDeleteReqVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by TS on 2019/8/31.
 */
@Component
public class TableExtendTemplateHystrix implements TableExtendTemplateFeign {

    @Override
    public ResultEntity add(TableExtendTemplateAddReqVo templateAddReqVo) {
        return ResultEntity.error(ExceptionEnum.HYSTRIX);
    }

    @Override
    public ResultEntity<List<String>> selectByFields(String siteCode, String tableCode) {
        return ResultEntity.error(ExceptionEnum.HYSTRIX);
    }

    @Override
    public ResultEntity deleteById(TableExtendTemplateDeleteReqVo templateDeleteReqVo) {
        return ResultEntity.error(ExceptionEnum.HYSTRIX);
    }
}
