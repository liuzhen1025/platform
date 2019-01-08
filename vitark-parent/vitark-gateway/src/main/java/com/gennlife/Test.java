/**
 * copyRight
 */
package com.gennlife;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/9
 * Time: 13:22
 */
public class Test {
    public static void main(String[] args){
            Pattern p = Pattern.compile("EDTA",Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher("EDTA狂");
            boolean matches = m.matches();
            StringBuffer buffer = new StringBuffer();
            if(matches){
                m.appendReplacement(buffer,"abc");
            }
            System.out.println("aadadfad");
    }
}
