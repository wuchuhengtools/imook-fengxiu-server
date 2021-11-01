package com.zhuche.server.api.v1;

import com.zhuche.server.model.BannerModel;
import com.zhuche.server.service.BannerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {
    protected BannerService _bannerService;

    public BannerController(BannerService bannerService) {
        this._bannerService = bannerService;
    }

    @GetMapping("/name/{name}")
    public BannerModel getByName(@PathVariable @NotBlank String name) {
        BannerModel banner = this._bannerService.getByName(name);

        return banner;
    }
}
