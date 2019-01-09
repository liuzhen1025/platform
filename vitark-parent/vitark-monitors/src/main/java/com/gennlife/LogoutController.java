/**
 * copyRight
 */
package com.gennlife;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/8
 * Time: 18:41
 */
@Controller
@RequestMapping("")
public class LogoutController {
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        return "success";
    }
}
