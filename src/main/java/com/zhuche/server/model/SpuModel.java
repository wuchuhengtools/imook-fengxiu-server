package com.zhuche.server.model;

import javax.persistence.*;

@Entity
@Table(name = "spu")
public class SpuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;
}
