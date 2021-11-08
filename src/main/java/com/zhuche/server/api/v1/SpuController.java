package com.zhuche.server.api.v1;

import com.zhuche.server.exception.http.NotFoundException;
import com.zhuche.server.model.SpuModel;
import com.zhuche.server.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Positive;

@Controller
@RequestMapping("/spu")
@Validated
@ResponseBody
public class SpuController {

    private final SpuService spuService;

    public SpuController(SpuService spuService) {
        this.spuService = spuService;

    }

    @GetMapping("/id/{id}/detail")
    public SpuModel getDetail( @PathVariable @Positive long id ) {
        SpuModel spu = this.spuService.getSpu(id);
        if (spu == null ) {
            throw new NotFoundException(30003);
        }

        return spu;
    }
}
