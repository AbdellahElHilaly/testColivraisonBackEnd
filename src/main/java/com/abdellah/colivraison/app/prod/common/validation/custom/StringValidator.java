package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidString;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringValidator implements ConstraintValidator<ValidString, String> {
    private int min;
    private String propertyName;

    private final Validator<String> validator;

    @Override
    public void initialize(ValidString constraintAnnotation) {

        min = constraintAnnotation.min();
        propertyName = constraintAnnotation.propertyName();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        validator.setPropertyName(propertyName);
        validator.setContext(context);
        validator.setMinLength(min);

        if (validator.isNull(value)) return false;

        validator.isEmpty(value);

        return validator.isTallerThan(value);
    }




}
