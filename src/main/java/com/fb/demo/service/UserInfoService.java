package com.fb.demo.service;

import com.fb.base.service.BaseService;
import com.fb.demo.bean.po.UserInfo;

/**
 * @author LYZ
 * @create 2018/12/29 14:11
 **/
public interface UserInfoService extends BaseService<UserInfo> {
    /**
     * 保存用户信息
     * @return
     */
    int insertByUserInfo();
}
