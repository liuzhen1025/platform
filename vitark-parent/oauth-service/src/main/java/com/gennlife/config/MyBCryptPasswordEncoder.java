package com.gennlife.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyBCryptPasswordEncoder implements PasswordEncoder {
    private Logger logger = LoggerFactory.getLogger(MyBCryptPasswordEncoder.class);

    /**
     *
     * @param rawPassword 用户输入的密码
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return getMD5(toHexString(rawPassword.toString()));
    }

    /**
     *
     * @param rawPassword  用户输入的密码
     * @param encodedPassword 加密后的密码
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            logger.info("Empty encoded password");
            return false;
        }
        return equalsPassword(getMD5(toHexString(rawPassword.toString())),encodedPassword);
    }

    public String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    public String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return str;
        }
    }

    public boolean equalsPassword(String a,String b){
        char[] caa = a.toCharArray();
        char[] cab = b.toCharArray();

        if (caa.length != cab.length) {
            return false;
        }

        byte ret = 0;
        for (int i = 0; i < caa.length; i++) {
            ret |= caa[i] ^ cab[i];
        }
        return ret == 0;
    }

    public static void main(String args[]){

        String encode = new BCryptPasswordEncoder().encode("webApp");
        System.out.println(encode);
        MyBCryptPasswordEncoder m = new MyBCryptPasswordEncoder();
        System.out.println(m.getMD5(m.toHexString("123456")));
        System.out.println(m.matches("123456",m.getMD5(m.toHexString("123456"))));
    }
}
