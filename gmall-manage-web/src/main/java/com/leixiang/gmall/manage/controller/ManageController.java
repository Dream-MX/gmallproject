package com.leixiang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leixiang.gmall.service.ManageService;
import com.leixiang.gmall.user.*;



import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName ManageController
 * @create 2019-12-05 15:54
 * @Description TODO
 */
@RestController
@CrossOrigin
public class ManageController {

    @Reference
    private ManageService manageService;

    @PostMapping("/getCatalog1")
    public List<BaseCatalog1> getCatalog1(){

        return manageService.getBaseCatalog1();
    }

    @PostMapping("/getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){

        return manageService.getBaseCatalog2(catalog1Id);
    }

    @PostMapping("/getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getBaseCatalog3(catalog2Id);
    }

    @GetMapping("/attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.attrInfoList(catalog3Id);
    }

    @PostMapping ("/saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        System.out.println(baseAttrInfo);
        manageService.saveAttrInfo(baseAttrInfo);
    }

    @PostMapping("/getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
        BaseAttrInfo baseAttrInfo = manageService.getAttrValueListByAttrId(attrId);

        return baseAttrInfo.getAttrValueList();

    }


}
