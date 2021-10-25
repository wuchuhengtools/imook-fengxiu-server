package com.zhuche.server.api.v1;

import com.zhuche.server.core.configuration.ExceptionCodeConfiguration;
import com.zhuche.server.exception.http.ForbiddenException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
@RequestMapping("/banner")
public class BannerController {

    @RequestMapping(value = "/test", method = {
            RequestMethod.GET,
    })
    public  String test(HttpServletResponse response) {
        System.out.println(this.getClass().getName());
        throw new ForbiddenException(10001);
    }
}
