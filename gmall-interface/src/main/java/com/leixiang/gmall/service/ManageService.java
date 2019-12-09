package com.leixiang.gmall.service;

import com.leixiang.gmall.user.*;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName ManageService
 * @create 2019-12-05 15:23
 * @Description TODO
 */
public interface ManageService {

    /**
     * 查询所有一级分类
     * @return
     */
    List<BaseCatalog1> getBaseCatalog1();

    /**
     * 根据一级分类id查询所有二级分类
     * @param baseCatalog1Id
     * @return
     */
    List<BaseCatalog2> getBaseCatalog2(String baseCatalog1Id);

    /**
     * 根据二级分类id查询所有三级分类
     * @param baseCatalog2Id
     * @return
     */
    List<BaseCatalog3> getBaseCatalog3(String baseCatalog2Id);

    /**
     * 根据三级分类id查询所有属性名称
     * @param baseCatalog3Id
     * @return
     */
    List<BaseAttrInfo> attrInfoList(String baseCatalog3Id);

    /**
     * 添加或修改平台属性
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据属性id查询所有属性
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrValueListByAttrId(String attrId);

    /**
     * 根据三类分级id获取所有spu信息
     * @param catalog3Id
     * @return
     */
    List<SpuInfo> spuList(String catalog3Id);

    /**
     * 获取基本属性
     * @return
     */
    List<BaseSaleAttr> baseSaleAttrList();

    /**
     * 添加商品spu信息
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);

    /**
     * 获取spu信息
     * @param spuId
     * @return
     */
    SpuInfo getSpuInfo(String spuId);

    /**
     * 保存商品sku信息
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 根据skuid查询完整sku信息
     * @param skuId
     * @return
     */
    SkuInfo getSkuInfoById(String skuId);
}
