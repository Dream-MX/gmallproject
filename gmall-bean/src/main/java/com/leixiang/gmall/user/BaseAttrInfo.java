package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.io.Serializable;
import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName BaseAttrInfo
 * @create 2019-12-05 15:13
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class BaseAttrInfo implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    @Transient
    private List<BaseAttrValue> attrValueList;

}
