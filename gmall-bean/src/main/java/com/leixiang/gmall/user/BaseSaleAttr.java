package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName BaseSaleAttr
 * @create 2019-12-06 14:06
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class BaseSaleAttr implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String name;



}
