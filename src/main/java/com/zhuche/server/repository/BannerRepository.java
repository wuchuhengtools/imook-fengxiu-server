package com.zhuche.server.repository;

import com.zhuche.server.model.BannerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<BannerModel, Long> {
    BannerModel findOneByName(String name);
}
