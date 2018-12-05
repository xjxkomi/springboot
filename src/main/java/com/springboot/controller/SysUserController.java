package com.springboot.controller;


import com.springboot.domain.SysRole;
import com.springboot.domain.SysUser;
import com.springboot.service.SysRoleService;
import com.springboot.service.SysUserService;
import com.springboot.service.impl.SysRoleServiceImpl;
import com.springboot.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping(value="admin/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService = new SysUserServiceImpl();
    @Autowired
    private SysRoleService sysRoleService = new SysRoleServiceImpl();


    @RequestMapping(value="list")
    public String list(@ModelAttribute SysUser sysUser , ModelMap modelMap ,
                       @RequestParam(value = "page", defaultValue = "0") Integer page ,
                       @RequestParam(value = "size", defaultValue = "10") Integer size){
        List <SysRole> sysRoleList = sysRoleService.findAll();
        Page<SysUser> sysUserPage = sysUserService.findPageWithParams(page,size,sysUser);
        //Page<SysUser> sysUserPage = sysUserService.findPage(page,size);
        modelMap.put("pageList", sysUserPage);
        modelMap.put("sysRoleList" , sysRoleList);
        return "user/list";
    }



}
