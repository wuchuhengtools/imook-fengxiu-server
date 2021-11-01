package com.zhuche.server.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "banner")
public class BannerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private short type;

    private String img;

    private String title;

    @OneToMany(mappedBy = "banner")
    private List<BannerItemModel> Items;
}
