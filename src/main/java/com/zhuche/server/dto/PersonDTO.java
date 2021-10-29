package com.zhuche.server.dto;

import com.zhuche.server.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Builder
@Getter
@PasswordEqual
public class PersonDTO {
    @Length(min = 2, max = 10, message =  "the length of name must be between 2 and 10")
    private String name;
    private Integer age;

    protected String password1;
    protected String password2;
}