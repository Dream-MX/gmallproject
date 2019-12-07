package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SpuSaleAttr
 * @create 2019-12-07 8:12
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class SpuSaleAttr implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String spuId;

    @Column
    private String saleAttrId;

    @Column
    private  String saleAttrName;

    @Transient
    private List<SpuSaleAttrValue> spuSaleAttrValueList;

}
