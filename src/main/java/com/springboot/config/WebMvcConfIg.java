package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * mvc配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * @return 登录验证拦截器
     * 自定义登录验证拦截器
     */
    @Autowired
    public LoginInterceptor loginInterceptor;

    /**
     * @param registry 配置静态资源放行
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * @param registry 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录处理拦截器，拦截所有请求，登录请求除外
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/admin/" ,"/admin/login","/base/**","/css/**","/scripts/**","/scss/**","/images/**").addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }


}
