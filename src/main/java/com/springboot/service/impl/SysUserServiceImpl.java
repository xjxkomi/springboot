package com.springboot.service.impl;

import com.springboot.domain.SysRole;
import com.springboot.domain.SysUser;
import com.springboot.repository.SysUserRepository;
import com.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;


    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    ;

    /*
     * 登录判断
     * */
    public List<SysUser> checkLogin(SysUser sysUser) {
        String u_password_md5 = DigestUtils.md5DigestAsHex(sysUser.getUPassword().getBytes());
        //System.out.println(u_password_md5);
        return sysUserRepository.findByUNameAndUPassword(sysUser.getUName(), u_password_md5);
    }

    /*
     * 查询列表带分页
     * */
    public Page<SysUser> findPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "uId");
        return sysUserRepository.findAll(pageable);
    }


    /*
    * 复杂查询带分页
    *
    public Page<SysUser> findePageAndparams(Integer page, Integer size , SysUser sysuser){

        Pageable  pageable = PageRequest.of(page , size , Sort.Direction.DESC, "uId");
        return sysUserRepository.findAll(pageable);
    }
    */


    public Page<SysUser> findPageWithParams(Integer page, Integer size, final SysUser sysUser) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "uId");
        Page<SysUser> sysUserPage = sysUserRepository.findAll(new Specification<SysUser>(){
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(null != sysUser.getUName() && !"".equals(sysUser.getUName())){
                    list.add(criteriaBuilder.like(root.get("uName").as(String.class), "%"+sysUser.getUName()+"%"));
                }
                if (null != sysUser.getIsDeleted() && sysUser.getIsDeleted() != -1)
                {
                    list.add(criteriaBuilder.equal(root.get("isDeleted").as(Integer.class), sysUser.getIsDeleted()));
                }
                if (null != sysUser.getSysRole() && sysUser.getSysRole().getRoleId() != -1){
                   list.add(criteriaBuilder.equal(root.join("sysRole").get("roleId").as(Integer.class),sysUser.getSysRole().getRoleId()));
                }
                Predicate[] predicate = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(predicate));
            }
        },pageable);
        return sysUserPage;
    }




}
