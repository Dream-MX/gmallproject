package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SpuInfo
 * @create 2019-12-06 8:22
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class SpuInfo implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String spuName;

    @Column
    private String description;

    @Column
    private  String catalog3Id;

    @Transient
    private List<SpuImage> spuImageList;

    @Transient
    private List<SpuSaleAttr> spuSaleAttrList;
}
