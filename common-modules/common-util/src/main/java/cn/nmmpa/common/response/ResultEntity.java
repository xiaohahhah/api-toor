package cn.nmmpa.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mister Tan
 * @param <T>
 */
@Data
public class ResultEntity<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public ResultEntity() {

    }

    public ResultEntity(int status, String message, T data) {
        this.code = status;
        this.message = message;
        this.data = data;
    }

    public ResultEntity(int status, String message) {
        this.code = status;
        this.message = message;
    }

    public ResultEntity(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.code();
        this.message = exceptionEnum.message();
    }

    public ResultEntity(T data) {
        this.data = data;
    }
    public ResultEntity(ExceptionEnum exceptionEnum , T t) {
        this.code = exceptionEnum.code();
        this.message = exceptionEnum.message();
        this.data = t;
    }

    /**
     * 操作成功，不返回参数
     * @return
     */
    public static ResultEntity success(){
        return new ResultEntity<>(ExceptionEnum.SUCCESS);
    }

    /**
     * 操作成功，返回参数
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> success(T t){
        return new ResultEntity<>(ExceptionEnum.SUCCESS , t);
    }

    /**
     * 操作失败
     * @param exceptionEnum
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> error(ExceptionEnum exceptionEnum ,T t){
        return new ResultEntity<>(exceptionEnum , t);
    }

    /**
     * 操作失败
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> error(T t){
        return new ResultEntity<>(ExceptionEnum.ERROR , t);
    }

    /**
     * 操作失败
     * @param code
     * @param message
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> error(int code , String message , T t){
        return new ResultEntity<>(code , message , t);
    }

    /**
     * 操作失败
     * @param exceptionEnum
     * @return
     */
    public static ResultEntity error(ExceptionEnum exceptionEnum){
        return new ResultEntity<>(exceptionEnum);
    }

    /**
     * 操作失败
     * @return
     */
    public static ResultEntity error(){
        return new ResultEntity<>(ExceptionEnum.ERROR);
    }

    /**
     * 操作失败
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> error(int code , String message){
        return new ResultEntity<>(code , message);
    }
}
