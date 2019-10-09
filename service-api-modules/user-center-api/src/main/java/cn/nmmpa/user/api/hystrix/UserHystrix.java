package cn.nmmpa.user.api.hystrix;

import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.api.UserFeign;
import cn.nmmpa.user.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2019/8/31.
 */
@Component
public class UserHystrix implements UserFeign {


    @Override
    public ResultEntity add(User user) throws Exception {
        return ResultEntity.error(ExceptionEnum.HYSTRIX);
    }
}
