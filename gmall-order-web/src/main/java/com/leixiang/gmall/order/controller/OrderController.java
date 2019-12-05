package com.leixiang.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leixiang.gmall.service.UserAddressService;
import com.leixiang.gmall.service.UserInfoService;
import com.leixiang.gmall.user.UserAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName OrderController
 * @create 2019-12-04 16:22
 * @Description TODO
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private UserAddressService userAddressService;

    @GetMapping("/getUserAddressListByUserId")
    public List<UserAddress> getOrderAddressListByUserId(String userId){

        return userAddressService.getOrderAddressListByUserId(userId);
    }

}
