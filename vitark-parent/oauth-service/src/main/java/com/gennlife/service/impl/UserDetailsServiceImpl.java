package com.gennlife.service.impl;

import com.gennlife.entity.RcMenuEntity;
import com.gennlife.entity.RcRoleEntity;
import com.gennlife.entity.RcUserEntity;
import com.gennlife.service.PermissionService;
import com.gennlife.service.RoleService;
import com.gennlife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户详细信息服务，获取用户的所有信息，基本信息，权限，角色等
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RcUserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        List<RcRoleEntity> roleValues = roleService.getRoleValuesByUserId(userEntity.getId());
        for (RcRoleEntity role:roleValues){
            //角色必须是ROLE_开头，可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
            grantedAuthorities.add(grantedAuthority);
            //获取权限
            List<RcMenuEntity> permissionList = permissionService.getPermissionsByRoleId(role.getId());
            for (RcMenuEntity menu:permissionList
                 ) {
                GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                grantedAuthorities.add(authority);
            }
        }
        User user = new User(userEntity.getUsername(), userEntity.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
