package com.zhuche.server.service;

import com.zhuche.server.model.BannerModel;
import com.zhuche.server.repository.BannerRepository;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService{
    private final BannerRepository _bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this._bannerRepository = bannerRepository;
    }

    @Override
    public BannerModel getByName(String name) {
        return this._bannerRepository.findOneByName(name);
    }
}
