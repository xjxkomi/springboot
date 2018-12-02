package com.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="sys_role")
public class SysRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long roleId;
    private String rName;
    private Date createTimer;
    //@Column(nullable = false , insertable = false, columnDefinition = "0")
    private boolean isDeleted;

}
