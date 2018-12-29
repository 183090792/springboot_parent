package com.fb.demo.controller;

import com.fb.demo.bean.vo.UserInfoVo;
import com.fb.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LYZ
 * @create 2018/12/29 14:10
 **/
@Slf4j
@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 新增用户信息
     * @param userInfoVo
     * @return
     */
    @RequestMapping(value = "/add" ,produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String insertByUserInfoPost(@RequestBody UserInfoVo userInfoVo){
        int result =  userInfoService.insertByUserInfo();
        log.debug("业务层返回的结果为===================>{}",result);
        return "help";
    }
    /**
     * 新增用户信息
     * @param userInfoVo
     * @return
     */
    @RequestMapping(value = "/add" ,produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String insertByUserInfoGet(UserInfoVo userInfoVo){
        int result =  userInfoService.insertByUserInfo();
        return "help";
    }
}
