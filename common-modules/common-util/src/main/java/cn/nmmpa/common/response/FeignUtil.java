package cn.nmmpa.common.response;

/**
 * @Author: tan shuai
 * @Date: 2019/7/30 14:37
 * @Version 1.0
 */
public class FeignUtil {

    /**
     * 获取返回数据，同时验证是否调用成功，未调用成功，则抛异常
     * @param resultEntity
     * @param <T>
     * @return
     */
    public static <T> T getData(ResultEntity<T> resultEntity){
        //如果为200 表示调用成功 直接返回
        if(resultEntity.getStatus() == ExceptionEnum.SUCCESS.code){
            return resultEntity.getData();
        }
        //如果不为200 表示调用失败 直接抛异常
        if(resultEntity.getStatus() != ExceptionEnum.SUCCESS.code){
            throw new FeignException(resultEntity.getStatus() , resultEntity.getMessage());
        }
        return null;
    }

    /**
     * 直接返回，不做任何处理
     * @param resultEntity
     * @param <T>
     * @return
     */
    public static <T> T getDataCatchException(ResultEntity<T> resultEntity){
        return resultEntity.getData();
    }

    /**
     * 检验是否调用成功
     * @param resultEntity
     * @param <T>
     */
    public static <T> void  checkResp(ResultEntity<T> resultEntity){
        //如果不为200 表示调用失败 直接抛异常
        if(resultEntity.getStatus() != ExceptionEnum.SUCCESS.code){
            throw new FeignException(resultEntity.getStatus() , resultEntity.getMessage());
        }
    }
}
