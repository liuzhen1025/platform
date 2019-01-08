package com.gennlife.service.impl;

import com.gennlife.dao.PermissionRepository;
import com.gennlife.entity.RcMenuEntity;
import com.gennlife.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限资源服务实现
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public List<RcMenuEntity> getPermissionsByRoleId(Integer roleId) {
        return permissionRepository.getPermissionsByRoleId(roleId);
    }
}
