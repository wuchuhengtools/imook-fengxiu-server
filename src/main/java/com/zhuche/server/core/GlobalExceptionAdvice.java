package com.zhuche.server.core;

import com.zhuche.server.core.configuration.ExceptionCodeConfiguration;
import com.zhuche.server.exception.http.HttpException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionAdvice {

    private final ExceptionCodeConfiguration _exceptionCodeConfiguration;

    public GlobalExceptionAdvice(ExceptionCodeConfiguration exceptionCodeConfiguration) {
        this._exceptionCodeConfiguration = exceptionCodeConfiguration;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req) {
        String url = req.getRequestURI();
        String method = req.getMethod();

        return new UnifyResponse(9999, "服务器内部错误",  method + " " + url);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        UnifyResponse message = new UnifyResponse(e.getCode(), this._exceptionCodeConfiguration.getMessage(e.getCode()), method + " " + requestUrl);
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.resolve(e.getHttpStatusCode());
        headers.setContentType(MediaType.APPLICATION_JSON);
        assert status != null;

        return new ResponseEntity<>(message, headers, status);
    }

    /**
     * 验证异常处理
     * @param req  HttpServletRequest
     * @param e MethodArgumentNotValidException
     * @return  UnifyResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleBeanValidation(HttpServletRequest req, MethodArgumentNotValidException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = "";
        for(ObjectError error : errors) {
            message = message.concat(Objects.requireNonNull(error.getDefaultMessage())) + ";";
        }
        message = message.substring(0, message.length() - 1) + ".";

        return  new UnifyResponse(1001, message, method + " " + requestUrl);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleConstraintViolationException(HttpServletRequest req, ConstraintViolationException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        StringBuilder message = new StringBuilder();
        for (ConstraintViolation<?> next : e.getConstraintViolations()) {
            String errorMessage = ((PathImpl) next.getPropertyPath()).getLeafNode().getName() + ":" + next.getMessage() + ";";
            message.append(errorMessage);
        }

        return  new UnifyResponse(1001, message.toString(), method + " " + requestUrl);
    }
}
