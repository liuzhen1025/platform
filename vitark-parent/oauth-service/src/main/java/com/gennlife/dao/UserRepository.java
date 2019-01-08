package com.gennlife.dao;

import com.gennlife.entity.RcUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RcUserEntity,Integer> {
    RcUserEntity findByUsername(String username);
}
