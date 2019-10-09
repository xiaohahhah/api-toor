package cn.nmmpa.common.util;

import cn.nmmpa.common.exception.BaseException;
import cn.nmmpa.common.response.ExceptionEnum;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by TS on 2018/12/27.
 */
public class EncryptUtil {

    private final static String EQ = "=";

    /**
     * 将map参数拼接 按字典顺序排序
     * @param param
     * @return
     */
    public static String getParamStr(Map<String , String> param){
        List<String> list = new ArrayList<>();
        param.entrySet().stream()
                .forEach(m -> {
                    if(!StringUtils.isEmpty(m.getValue())){
                        list.add(new StringBuilder().append(m.getKey()).append(EQ).append(m.getValue()).toString());
                    }
                });
        String [] arrayToSort = list.toArray(new String[list.size()]);
        //字典排序方式
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arrayToSort).forEach(s -> sb.append(s).append("&"));
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 检验加密串
     * @param t
     * @param <T>
     */
    public static <T> void checkSign(T t){
        if(t == null){
            throw new BaseException(ExceptionEnum.PARAM_ERROR.setMessage("验签对象不能为空"));
        }
        Map<String , String> params = (Map<String, String>) JSONObject.toJSON(t);
        String sign = params.get("sign");
        params.remove("sign");
        if(sign == null || "".equals(sign)){
            throw new BaseException(ExceptionEnum.PARAM_ERROR.setMessage("验签参数不能为空"));
        }
        String paramStr = getParamStr(params);
        String s = MD5Util.MD5(paramStr);
        if(!s.equals(sign)){
            throw new BaseException(ExceptionEnum.PARAM_ERROR.setMessage("数据验签失败"));
        }
    }
}
