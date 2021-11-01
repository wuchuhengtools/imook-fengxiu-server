package com.zhuche.server.model;

import javax.persistence.*;

@Entity
@Table(name = "banner_item")
public class BannerItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String img;

    private String keyword;

    private short type;

    private String name;

    protected Long bannerId;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "bannerId")
    private BannerModel banner;
}
