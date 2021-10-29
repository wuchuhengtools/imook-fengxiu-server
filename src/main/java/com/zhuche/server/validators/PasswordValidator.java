package com.zhuche.server.validators;

import com.zhuche.server.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    private int _min;
    private int _max;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        _min = constraintAnnotation.min();
        _max = constraintAnnotation.max();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PersonDTO value, ConstraintValidatorContext context) {
        Class<PersonDTO> personDTOClass = PersonDTO.class;
        String password1 = value.getPassword1();
        String password2 = value.getPassword2();
        if (!password1.equals(password2)) {
            return false;
        }
        if (password1.length() < _min) {
            return false;
        }

        return password1.length() < _max;
    }
}
