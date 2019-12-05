package com.leixiang.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.leixiang.gmall.service.UserInfoService;

import com.leixiang.gmall.user.UserInfo;

import com.leixiang.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserInfoServiceImpl
 * @create 2019-12-04 15:28
 * @Description TODO
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {

    }

    @Override
    public void updateUser(UserInfo userInfo) {

    }

    @Override
    public void deleteUser(UserInfo userInfo) {

    }

    @Override
    public List<UserInfo> getgetUserByExample(String nickName) {
        return null;
    }


}
