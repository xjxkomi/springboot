package com.springboot.service;


import com.springboot.domain.SysUser;

import java.util.List;

public interface SysUserService {

    public List<SysUser> findAll();

    public List<SysUser> checkLogin(SysUser sysUser);

}
