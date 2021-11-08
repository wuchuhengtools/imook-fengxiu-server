package com.zhuche.server.service;

import com.zhuche.server.model.SpuModel;
import com.zhuche.server.repository.SpuRepository;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService {
    final SpuRepository spuRepository;

    public SpuServiceImpl(SpuRepository spuRepository) {
        this.spuRepository = spuRepository;
    }

    @Override
    public SpuModel getSpu(long id) {
        return this.spuRepository.findOneById(id);
    }
}
