package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SpuSaleAttrValue
 * @create 2019-12-07 8:26
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class SpuSaleAttrValue implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String spuId;

    @Column
    private String saleAttrId;

    @Column
    private  String saleAttrValueName;

    @Transient
    String isChecked;
}
