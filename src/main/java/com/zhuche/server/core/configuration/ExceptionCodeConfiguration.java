package com.zhuche.server.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "exception")
@PropertySource(value = "classpath:config/exception-code.properties")
@Component
public class ExceptionCodeConfiguration {

    private Map<Integer, String> codeMapMessage = new HashMap<>();

    public Map<Integer, String> getCodeMapMessage() {
        return codeMapMessage;
    }

    public void setCodeMapMessage(Map<Integer, String> codeMapMessage) {
        this.codeMapMessage = codeMapMessage;
    }

    public String getMessage(int code) {
        String message = this.codeMapMessage.get(code);

        return message;
    }
}
