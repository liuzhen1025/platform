package com.gennlife.dao;

import com.gennlife.entity.RcMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<RcMenuEntity,Integer> {
    @Query(value = "select menu.* from rc_menu menu,rc_privilege p where menu.id=p.menu_id and p.role_id=?1",nativeQuery = true)
    List<RcMenuEntity> getPermissionsByRoleId(Integer roleId);
}
