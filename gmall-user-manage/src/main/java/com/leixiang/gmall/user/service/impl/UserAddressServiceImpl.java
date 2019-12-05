package com.leixiang.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.leixiang.gmall.service.UserAddressService;
import com.leixiang.gmall.user.UserAddress;
import com.leixiang.gmall.user.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserAddressServiceImpl
 * @create 2019-12-04 16:50
 * @Description TODO
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> getOrderAddressListByUserId(String userId) {
        Example example = new Example(UserAddress.class);
        example.createCriteria().andEqualTo("userId",userId);
        return userAddressMapper.selectByExample(example);
    }
}
