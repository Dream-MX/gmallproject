package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName BaseCatalog3
 * @create 2019-12-05 15:10
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class BaseCatalog3 implements Serializable {

    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String catalog2Id;

}
