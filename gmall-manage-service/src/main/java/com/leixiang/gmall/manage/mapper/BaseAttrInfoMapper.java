package com.leixiang.gmall.manage.mapper;

import com.leixiang.gmall.user.BaseAttrInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName BaseAttrInfoMapper
 * @create 2019-12-05 15:17
 * @Description TODO
 */
public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {

    /**
     * 根据三级分类id查询所有平台属性
     * @param baseCatalog3Id
     * @return
     */
    List<BaseAttrInfo> getAttrInfoListByCatalog3Id(@Param("catalog3Id") String baseCatalog3Id);
}
