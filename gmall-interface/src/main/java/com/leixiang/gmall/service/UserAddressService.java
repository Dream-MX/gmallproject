package com.leixiang.gmall.service;

import com.leixiang.gmall.user.UserAddress;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserAddressService
 * @create 2019-12-04 16:49
 * @Description TODO
 */
public interface UserAddressService {

    /**
     * 根据用户id获取用户收件地址
     * @param userId
     * @return
     */
    List<UserAddress> getOrderAddressListByUserId(String userId);
}
