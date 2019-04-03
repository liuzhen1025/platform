/**
 * copyRight
 */
package com.gennlife.exception;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/6/24
 * Time: 11:01
 */
public class ExceptionMessage {
    private String code;
    private String message;

    public ExceptionMessage(CustomerException e){
        this.code = e.getCode();
        this.message = e.getMessage();
    }
    public ExceptionMessage(CustomerStatusEnum exceptionEnum){
        this.message = exceptionEnum.getMessage();
        this.code = exceptionEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
