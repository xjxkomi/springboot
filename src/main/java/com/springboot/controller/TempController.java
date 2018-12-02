package com.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* @RestController 返回JSON，使用@RestController后，无需配置@ResponeBody
* */
@RestController
@RequestMapping(value="temp")
public class TempController {

    /*
    * @RequestMapping 指定访问路径
    * */
    @RequestMapping("/")
    public String index(){
        return "from controller";
    }


}
