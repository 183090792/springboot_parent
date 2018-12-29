package com.fb.demo.bean.vo;

import lombok.Data;

/**
 * @author LYZ
 * @create 2018/12/6 11:02
 **/
@Data
public class UserInfoVo {
    private Integer userId;
    private String userName;
    private String password;
    private String phone;
    private String createTime;
    private String updateTime;
    private String modifier;
}