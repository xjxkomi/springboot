package com.springboot.service;


import com.springboot.domain.SysUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SysUserService {

    List<SysUser> findAll();

    List<SysUser> checkLogin(SysUser sysUser);

    Page<SysUser> findSysUserNoCriteria(Integer page, Integer size);

}
