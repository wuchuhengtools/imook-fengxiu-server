package com.zhuche.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "banner")
public class BannerModel {
    @Id
    private long id;

    private String name;

    private String description;

    private String img;

    private String title;
}
