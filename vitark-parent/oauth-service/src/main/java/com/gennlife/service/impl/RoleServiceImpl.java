package com.gennlife.service.impl;

import com.gennlife.dao.RoleRepository;
import com.gennlife.entity.RcRoleEntity;
import com.gennlife.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务实现
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<RcRoleEntity> getRoleValuesByUserId(Integer userId) {
        return roleRepository.getRoleValuesByUserId(userId);
    }
}
