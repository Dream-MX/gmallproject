package com.leixiang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.leixiang.gmall.manage.mapper.*;
import com.leixiang.gmall.service.ManageService;
import com.leixiang.gmall.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName ManageSeviceImpl
 * @create 2019-12-05 15:46
 * @Description TODO
 */
@Service
public class ManageSeviceImpl implements ManageService {

    @Autowired
    private BaseCatalog1Mapper catalog1Mapper;

    @Autowired
    private BaseCatalog2Mapper catalog2Mapper;

    @Autowired
    private BaseCatalog3Mapper catalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper attrInfoMapper;

    @Autowired
    private BaseAttrValueMapper attrValueMapper;

    @Autowired
    private SpuInfoMapper spuInfoMapper;

    @Autowired
    private BaseSaleAttrMapper saleAttrMapper;

    @Autowired
    private SpuImageMapper spuImageMapper;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Override
    public List<BaseCatalog1> getBaseCatalog1() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getBaseCatalog2(String baseCatalog1Id) {
        Example example = new Example(BaseCatalog2.class);
        example.createCriteria().andEqualTo("catalog1Id", baseCatalog1Id);
        return catalog2Mapper.selectByExample(example);

    }

    @Override
    public List<BaseCatalog3> getBaseCatalog3(String baseCatalog2Id) {
        Example example = new Example(BaseCatalog3.class);
        example.createCriteria().andEqualTo("catalog2Id", baseCatalog2Id);
        return catalog3Mapper.selectByExample(example);
    }

    @Override
    public List<BaseAttrInfo> attrInfoList(String baseCatalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(baseCatalog3Id);
        List<BaseAttrInfo> baseAttrInfoList = attrInfoMapper.select(baseAttrInfo);

        BaseAttrValue baseAttrValue = new BaseAttrValue();

        for (BaseAttrInfo attrInfo : baseAttrInfoList) {
            baseAttrValue.setAttrId(attrInfo.getId());
            List<BaseAttrValue> attrValueList = attrValueMapper.select(baseAttrValue);
            attrInfo.setAttrValueList(attrValueList);
        }

        return baseAttrInfoList;
    }

    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if (baseAttrInfo.getId() != null && baseAttrInfo.getId().length() > 0) {
            attrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        } else {
            baseAttrInfo.setId(null);
            attrInfoMapper.insertSelective(baseAttrInfo);
        }

        BaseAttrValue baseAttrValue1 = new BaseAttrValue();
        baseAttrValue1.setAttrId(baseAttrInfo.getId());
        attrValueMapper.delete(baseAttrValue1);

        if(baseAttrInfo.getAttrValueList()!=null && baseAttrInfo.getAttrValueList().size()>0) {
            for (BaseAttrValue baseAttrValue : baseAttrInfo.getAttrValueList()) {
                baseAttrValue.setId(null);
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                attrValueMapper.insert(baseAttrValue);
            }
        }
    }

    @Override
    public BaseAttrInfo getAttrValueListByAttrId(String attrId) {
        BaseAttrInfo baseAttrInfo = attrInfoMapper.selectByPrimaryKey(attrId);
        Example example = new Example(BaseAttrValue.class);
        example.createCriteria().andEqualTo("attrId",attrId);
        List<BaseAttrValue> baseAttrValues = attrValueMapper.selectByExample(example);
        baseAttrInfo.setAttrValueList(baseAttrValues);
        return baseAttrInfo;
    }

    @Override
    public List<SpuInfo> spuList(String catalog3Id) {
        Example example = new Example(SpuInfo.class);
        example.createCriteria().andEqualTo("catalog3Id",catalog3Id);
        return spuInfoMapper.selectByExample(example);

    }

    @Override
    public List<BaseSaleAttr> baseSaleAttrList() {

        return saleAttrMapper.selectAll();
    }

    @Override
    @Transactional
    public void saveSpuInfo(SpuInfo spuInfo) {

        spuInfoMapper.insertSelective(spuInfo);

        //获取上传图片地址
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if(spuImageList != null && spuImageList.size() > 0){
            for (SpuImage spuImage : spuImageList) {
                spuImage.setSpuId(spuInfo.getId());
                spuImageMapper.insertSelective(spuImage);
            }
        }
        //获取所有销售属性
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if(spuSaleAttrList!=null&& spuSaleAttrList.size()>0){
            for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
                spuSaleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrMapper.insertSelective(spuSaleAttr);

                //获取所有销售属性值
                List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
                if(spuSaleAttrValueList != null && spuSaleAttrValueList.size() >0){
                    for (SpuSaleAttrValue spuSaleAttrValue : spuSaleAttrValueList) {
                        spuSaleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValueMapper.insertSelective(spuSaleAttrValue);
                    }
                }
            }

        }

    }

    @Override
    public SpuInfo getSpuInfo(String spuId) {
        //查询商品spu信息
        SpuInfo spuInfo = spuInfoMapper.selectByPrimaryKey(spuId);
        //查询商品销售属性名信息
        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
        spuSaleAttr.setSpuId(spuInfo.getId());
        List<SpuSaleAttr> saleAttrList = spuSaleAttrMapper.select(spuSaleAttr);
        for (SpuSaleAttr saleAttr : saleAttrList) {
            //查询商品销售属性值信息
            SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
            spuSaleAttrValue.setSpuId(spuInfo.getId());
            spuSaleAttrValue.setSaleAttrId(saleAttr.getSaleAttrId());
            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttrValueMapper.select(spuSaleAttrValue);
            saleAttr.setSpuSaleAttrValueList(spuSaleAttrValueList);
        }

        spuInfo.setSpuSaleAttrList(saleAttrList);
        //查询商品图片信息
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuInfo.getId());
        List<SpuImage> imageList = spuImageMapper.select(spuImage);
        spuInfo.setSpuImageList(imageList);
        return spuInfo;

    }
}
