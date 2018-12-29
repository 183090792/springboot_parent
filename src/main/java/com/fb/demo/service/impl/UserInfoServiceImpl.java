package com.fb.demo.service.impl;

import com.fb.base.service.impl.BaseServiceImpl;
import com.fb.demo.bean.po.UserInfo;
import com.fb.demo.mapper.UserInfoMapper;
import com.fb.demo.service.UserInfoService;
import com.fb.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LYZ
 * @create 2018/12/29 14:11
 **/
@Slf4j
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * 保存用户信息
     *
     * @return
     */
    @Override
    public int insertByUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("123");
        userInfo.setPassword(String.valueOf(System.currentTimeMillis()));
        userInfo.setCreateTime(DateUtil.getNowDateString());
        userInfoMapper.insertSelective(userInfo);
//        int i=1/0;
        return 1;
    }
}
