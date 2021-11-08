package com.zhuche.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "spu")
public class SpuModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String subtitle;
    private Long categoryId;
    private Long rootCategoryId;
    private Boolean online;

    @Column(columnDefinition = "varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文本型价格，有时候SPU需要展示的是一个范围，或者自定义平均价格'")
    private String price;

    @Column( columnDefinition = "int(10) unsigned DEFAULT NULL COMMENT '某种规格可以直接附加单品图片'" )
    private Integer sketchSpecId;

    @Column(columnDefinition = "int(11) DEFAULT NULL COMMENT '默认选中的sku'")
    private Integer defaultSkuId;

    private String img;
    private String discountPrice;
    private String description;
    private String tags;

    @Column( columnDefinition = "tinyint(3) unsigned DEFAULT '0'")
    private Short isTest;

//    private Object spuThemeImg;
    private String forThemeImg;
}
