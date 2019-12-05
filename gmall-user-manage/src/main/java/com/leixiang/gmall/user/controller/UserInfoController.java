package com.leixiang.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leixiang.gmall.service.UserInfoService;
import com.leixiang.gmall.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserController
 * @create 2019-12-04 15:27
 * @Description TODO
 */

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/findAll")
    public List<UserInfo> findAll(){
       return userInfoService.findAll();
    }
}
