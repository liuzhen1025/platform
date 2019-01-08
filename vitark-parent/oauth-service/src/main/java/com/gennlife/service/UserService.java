package com.gennlife.service;


import com.gennlife.entity.RcUserEntity;

/**
 * 用户服务
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
public interface UserService {
    RcUserEntity findByUsername(String username);
}
