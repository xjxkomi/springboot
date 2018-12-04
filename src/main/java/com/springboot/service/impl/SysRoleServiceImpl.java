package com.springboot.service.impl;

import com.springboot.domain.SysRole;
import com.springboot.repository.SysRoleRepository;
import com.springboot.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    public List<SysRole> findAll(){
        return sysRoleRepository.findAll();
    }

}
