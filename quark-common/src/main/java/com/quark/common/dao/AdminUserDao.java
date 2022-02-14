package com.quark.common.dao;

import com.quark.common.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

/**
 * Created by lhr on 17-7-31.
 */
@Mapper
@CacheConfig(cacheNames = "adminusers")
public interface AdminUserDao  {
//public interface AdminUserDao extends JpaRepository<AdminUser,Integer>,JpaSpecificationExecutor {

//    @Override
//    AdminUser getOne(Integer integer);

    @Cacheable
//    @Override
    List<AdminUser> findAll();

    AdminUser findByUsername(String username);

    @Cacheable
//    @Override
    List findAll(int pageNo, int length);
}
