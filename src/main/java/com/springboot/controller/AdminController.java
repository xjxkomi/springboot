package com.springboot.controller;

import com.springboot.domain.SysUser;
import com.springboot.service.SysUserService;
import com.springboot.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value="admin")
public class AdminController {


    //@Autowired
    //private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserService sysUserService = new SysUserServiceImpl();


    @RequestMapping(value="/")
    public String admin(ModelMap map){
        SysUser sysUser = new SysUser();
        map.put("name","komi");
        map.put("sysUser",sysUser);
        return "login";
    }

    @RequestMapping(value="main")
    public String main(ModelMap map){
        return "main";
    }

    @RequestMapping(value="login")
    public String login(@ModelAttribute SysUser sysUser , ModelMap map , HttpServletRequest request){
        List<SysUser> list = sysUserService.checkLogin(sysUser);
        if (list.size()>0) {
            request.getSession().setAttribute("sysUser",list.get(0));
            return "main";
        }
        else {
            map.put("msg","用户名密码错误，请确认！");
            return "login";
        }

    }


}
