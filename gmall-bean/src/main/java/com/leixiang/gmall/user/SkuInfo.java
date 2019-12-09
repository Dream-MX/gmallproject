package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SkuInfo
 * @create 2019-12-07 16:45
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class SkuInfo implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column
    String spuId;

    @Column
    BigDecimal price;

    @Column
    String skuName;

    @Column
    BigDecimal weight;

    @Column
    String skuDesc;

    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;

    @Transient
    private List<SkuAttrValue> skuAttrValueList;
    @Transient
    private List<SkuImage> skuImageList;
    @Transient
    private List<SkuSaleAttrValue> skuSaleAttrValueList;
}
