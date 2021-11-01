package com.zhuche.server.service;

import com.zhuche.server.model.BannerModel;

public interface BannerService {
    BannerModel getByName(String name);
}
