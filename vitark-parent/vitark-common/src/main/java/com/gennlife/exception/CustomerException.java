/**
 * copyRight
 */
package com.gennlife.exception;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/6/23
 * Time: 18:56
 */
public class CustomerException extends RuntimeException{
    private String code;
    private String message;
    public CustomerException() {
        super();
    }
    public CustomerException(CustomerStatusEnum exceptionEnum){
        this.message = exceptionEnum.getMessage();
        this.code = exceptionEnum.getCode();

    }
    public CustomerException(String code,String message){
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
