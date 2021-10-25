package com.zhuche.server.core;

import com.zhuche.server.core.configuration.ExceptionCodeConfiguration;
import com.zhuche.server.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration _exceptionCodeConfiguration;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        String url = req.getRequestURI();
        String method = req.getMethod();
        System.out.println(e);

        return new UnifyResponse(9999, "服务器内部错误",  method + " " + url);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity handleHttpException(HttpServletRequest req, HttpException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        UnifyResponse message = new UnifyResponse(e.getCode(), this._exceptionCodeConfiguration.getMessage(e.getCode()), method + " " + requestUrl);
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.resolve(e.getHttpStatusCode());
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<UnifyResponse> res = new ResponseEntity<UnifyResponse>(message, headers, status);

        return res;
    }
}
