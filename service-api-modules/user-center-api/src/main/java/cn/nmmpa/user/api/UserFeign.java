package cn.nmmpa.user.api;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: tan shuai
 * @Date: 2019/9/2 12:32
 * @Version 1.0
 */
@FeignClient(value = "USER-SERVICE-MODULE")
public interface UserFeign {

    /**
     * 新增站点用户
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user/add")
    ResultEntity add(@RequestBody User user) throws Exception;
}
