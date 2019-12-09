package com.leixiang.gmall.manage.mapper;

import com.leixiang.gmall.user.SpuSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SpuSaleAttrMapper
 * @create 2019-12-07 8:40
 * @Description TODO
 */
public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {
    /**
     * 根据三级分类id查询平台属性
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSaleAttrLiseBySpuId( @Param("spuId") String spuId);
}
