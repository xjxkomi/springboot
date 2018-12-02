package com.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="sys_user")
public class SysUser {

    @Id
    @Column(name="u_id")
    private Long uId;
    @ManyToOne
    @JoinColumn(name="role_id")
    private SysRole sysRole;
    @Column(name="u_name")
    private String uName;
    @Column(name="u_password")
    private String uPassword;
    @Column(name="u_last_login_timer")
    private Date uLastLoginTimer;
    @Column(name="is_deleted")
    private boolean isDeleted;

}
