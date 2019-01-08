package com.gennlife.service.impl;

import com.gennlife.dao.UserRepository;
import com.gennlife.entity.RcUserEntity;
import com.gennlife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RcUserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
