package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin/products")
public class ProductsController {


    @RequestMapping(value="typeList")
    public String typeList(ModelMap mpdelMap){
        System.out.println("typeList");
        mpdelMap.put("msg","hahaha");
        return "products/typeList";
    }

}
