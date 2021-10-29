package com.zhuche.server.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordEqual {
    int min() default 8;
    int max() default 20;
    String message() default "passwords are not equal";

    Class<?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};


}
