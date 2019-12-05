package com.leixiang.gmall.service;


import com.leixiang.gmall.user.UserInfo;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserInfoService
 * @create 2019-12-03 16:25
 * @Description TODO
 */
public interface UserInfoService {

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo
     */
    void updateUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param userInfo
     */
    void deleteUser(UserInfo userInfo);

    /**
     * 根据昵称查询用户
     * @param nickName
     * @return
     */
    List<UserInfo> getgetUserByExample(String nickName);

}
