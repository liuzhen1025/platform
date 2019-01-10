/**
 * copyRight
 */
package com.gennlife.rws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/9
 * Time: 16:42
 */
@Component
public class PropertiesCheck {
    @Value("${myconfig}")
    private String env;
    @PostConstruct
    public void checkProperties(){
        if(env!=null){
            System.out.println("============================");
        }
    }
}
