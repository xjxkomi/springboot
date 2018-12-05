package com.springboot.repository;

import com.springboot.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRepository extends JpaRepository <SysUser, Long> , JpaSpecificationExecutor<SysUser> {


    List <SysUser> findByUNameAndUPassword(String uName , String uPassword);




}
