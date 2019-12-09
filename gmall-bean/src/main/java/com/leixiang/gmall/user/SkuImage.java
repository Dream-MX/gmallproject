package com.leixiang.gmall.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName SkuImage
 * @create 2019-12-08 12:49
 * @Description TODO
 */
@Data
@NoArgsConstructor
public class SkuImage implements Serializable {

    @Id
    @Column
    String id;
    @Column
    String skuId;
    @Column
    String imgName;
    @Column
    String imgUrl;
    @Column
    String spuImgId;
    @Column
    String isDefault;
}
