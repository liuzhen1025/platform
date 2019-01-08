package com.gennlife.service;


import com.gennlife.entity.RcMenuEntity;
import com.gennlife.entity.RcRoleEntity;
import com.gennlife.entity.RcUserEntity;

import java.util.List;

/**
 * 权限资源服务
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
public interface PermissionService {
    List<RcMenuEntity> getPermissionsByRoleId(Integer roleId);
}
