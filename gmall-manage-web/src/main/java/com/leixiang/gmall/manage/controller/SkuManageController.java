package com.leixiang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leixiang.gmall.service.ManageService;
import com.leixiang.gmall.user.SkuInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SkuManageController
 * @create 2019-12-07 16:39
 * @Description TODO
 */
@RestController
@CrossOrigin
public class SkuManageController {

    @Reference
    private ManageService manageService;

    @PostMapping("/saveSkuInfo")
    public void saveSkuInfo(@RequestBody() SkuInfo skuInfo){
        manageService.saveSkuInfo(skuInfo);
    }
}
