package com.zhuche.server.api.v1;

import com.zhuche.server.dto.PersonDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {
    @RequestMapping(value = "/test/{name}", method = RequestMethod.POST)
    public String test(
            @RequestBody @Validated PersonDTO personDTO,
            @PathVariable @Length(min = 1, max = 2) String name,
            @RequestParam @Length(min = 1, max = 2) String page
            ) {
        return "success";
    }
}
