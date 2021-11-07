package com.zhuche.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banner")
@Getter
@Setter
public class BannerModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String img;
    private String name;
    private String title;

    @OneToMany
    @JoinColumn(name = "banner_id")
    private List<BannerItemModel> items;
}
