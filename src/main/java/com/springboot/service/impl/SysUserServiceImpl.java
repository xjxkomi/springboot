package com.springboot.service.impl;

import com.springboot.domain.SysUser;
import com.springboot.repository.SysUserRepository;
import com.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;


    public List<SysUser> findAll(){
        return sysUserRepository.findAll();
    };

    public List<SysUser> checkLogin(SysUser sysUser){
        String u_password_md5 = DigestUtils.md5DigestAsHex(sysUser.getUPassword().getBytes());
        //System.out.println(u_password_md5);
        return sysUserRepository.findByUNameAndUPassword(sysUser.getUName() , u_password_md5);
    }


    public Page<SysUser> findSysUserNoCriteria(Integer page,Integer size) {
        Pageable  pageable = PageRequest.of(page , size , Sort.Direction.DESC, "uId");
        return sysUserRepository.findAll(pageable);
    }





}
