package com.leixiang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leixiang.gmall.service.ManageService;
import com.leixiang.gmall.user.BaseSaleAttr;
import com.leixiang.gmall.user.SpuImage;
import com.leixiang.gmall.user.SpuInfo;
import com.leixiang.gmall.user.SpuSaleAttr;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SpuManageController
 * @create 2019-12-06 14:12
 * @Description TODO
 */
@RestController
@CrossOrigin
public class SpuManageController {

    @Reference
    private ManageService manageService;

    @GetMapping("/spuList")
    public List<SpuInfo> spuList(String catalog3Id){

        return manageService.spuList(catalog3Id);
    }

    @PostMapping("/baseSaleAttrList")
    public List<BaseSaleAttr> baseSaleAttrList(){
        return manageService.baseSaleAttrList();
    }

    @PostMapping("/saveSpuInfo")
    public void saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.saveSpuInfo(spuInfo);
    }

    @GetMapping("/spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        SpuInfo spuInfo = manageService.getSpuInfo(spuId);
        return spuInfo.getSpuSaleAttrList();
    }

    @GetMapping("/spuImageList")
    public List<SpuImage> spuImageList(String spuId){
        SpuInfo spuInfo = manageService.getSpuInfo(spuId);
        return spuInfo.getSpuImageList();
    }
}
