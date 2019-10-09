package cn.nmmpa.common.exception;

import cn.nmmpa.common.response.ExceptionEnum;
import cn.nmmpa.common.response.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author Mister Tan
 * 统一返回模板
 */

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {


    /**
     * 基础层自定义异常统一拦截
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ProviderServiceException.class)
    public ResultEntity basicServiceExceptionHandler(ProviderServiceException exception){
        exception.printStackTrace();
        return new ResultEntity(exception.getCode() == 0 ? 500 : exception.getCode() , exception.getMessage());
    }

    /**
     * 业务层自定义异常统一拦截
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ConsumerServiceException.class)
    public ResultEntity businessServiceExceptionHandler(ConsumerServiceException exception){
        exception.printStackTrace();
        return new ResultEntity<>(exception.getCode() == 0 ? 500 : exception.getCode() , exception.getMessage());
    }

    /**
     * 表单认证异常处理
     * @param methodArgumentNotValid
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultEntity<?> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValid){
        methodArgumentNotValid.printStackTrace();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，错误信息
        StringBuilder errorMsg = new StringBuilder("[");
        for (FieldError error : methodArgumentNotValid.getBindingResult().getFieldErrors()) {
            errorMsg.append(error.getField()).append("参数").append(error.getDefaultMessage()).append(",");
        }
        String message = new StringBuffer(errorMsg.substring(0 , errorMsg.length() - 1)).append("]").toString();
        return ResultEntity.error(ExceptionEnum.PARAM_ERROR.setMessage(message));
    }

    /**
     * 表单认证异常处理
     * @param constraintViolation
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResultEntity<?> constraintViolationExceptionHandler(ConstraintViolationException constraintViolation){
        StringBuilder errorInfo = new StringBuilder("[");
        Set<ConstraintViolation<?>> violations = constraintViolation.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            errorInfo.append(item.getMessage()).append(",");
        }
        String message = new StringBuilder(errorInfo.substring(0 , errorInfo.length() - 1)).append("]").toString();
        return ResultEntity.error(ExceptionEnum.PARAM_ERROR.setMessage(message));
    }

    /**
     * 全局统一拦截exception异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultEntity exceptionHandler(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
        return new ResultEntity<>(500 , e.getMessage()+"");
    }
}

