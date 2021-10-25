package com.zhuche.server.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {
    @Value("${api-package}")
    private  String  _apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if (mappingInfo != null) {
            String prefixUrl = this._getPrefix(handlerType);
            return RequestMappingInfo.paths(prefixUrl).build().combine(mappingInfo);
        }

        return mappingInfo;
    }

    private String _getPrefix(Class<?> handlerType ) {
        String packageName = handlerType.getPackage().getName();
        String dotPath = packageName.replace(this._apiPackagePath, "");

        return dotPath.replace(".", "/");
    }
}
