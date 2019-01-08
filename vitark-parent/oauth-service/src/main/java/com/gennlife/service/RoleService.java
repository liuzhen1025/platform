package com.gennlife.service;


import com.gennlife.entity.RcRoleEntity;

import java.util.List;

/**
 * 角色服务
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
public interface RoleService {
    List<RcRoleEntity> getRoleValuesByUserId(Integer userId);
}
