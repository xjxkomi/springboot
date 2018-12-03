package com.springboot.controller;


import com.springboot.domain.SysUser;
import com.springboot.service.SysUserService;
import com.springboot.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value="admin/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService = new SysUserServiceImpl();

    @RequestMapping(value="list")
    public String list(@ModelAttribute SysUser sysUser , ModelMap modelMap){
        List<SysUser> list = sysUserService.findAll();
        modelMap.put("userList" , list);
        System.out.println("user/list");
        return "user/list";
    }



}
