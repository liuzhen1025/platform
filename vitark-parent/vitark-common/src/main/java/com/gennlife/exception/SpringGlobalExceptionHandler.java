/**
 * copyRight
 */
package com.gennlife.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/6/24
 * Time: 10:56
 */
@ControllerAdvice
public class SpringGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionMessage exceptionHandler(HttpServletRequest request, Exception e){
        if(e instanceof CustomerException){
            CustomerException exception = (CustomerException) e;
            return new ExceptionMessage(exception);
        }
        return new ExceptionMessage(CustomerStatusEnum.SYSTEMEXCEPTION);
    }
}
