package com.zhuche.server.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "theme")
public class ThemeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "theme_spu",
            joinColumns = @JoinColumn(name = "theme_id"),
            inverseJoinColumns = @JoinColumn(name = "spu_id")
    )
    private List<SpuModel> spuList;
}
