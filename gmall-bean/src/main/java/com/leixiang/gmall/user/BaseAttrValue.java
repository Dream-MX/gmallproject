package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName BaseAttrValue
 * @create 2019-12-05 15:14
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class BaseAttrValue implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String valueName;
    @Column
    private String attrId;
}
