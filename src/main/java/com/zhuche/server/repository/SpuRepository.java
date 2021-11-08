package com.zhuche.server.repository;

import com.zhuche.server.model.SpuModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<SpuModel, Long> {
    SpuModel findOneById(Long id);
}
