package com.fb.demo.bean.po;

import lombok.Data;

import javax.persistence.*;

/**
 * @author LYZ
 * @create 2018/12/6 11:02
 **/
@Data
@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "update_time")
    private String updateTime;
    @Column(name = "modifier")
    private String modifier;
}