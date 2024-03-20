package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidBoolean;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BooleanValidator implements ConstraintValidator<ValidBoolean, String> {

    private final Validator<String> validator;
    private String propertyName;

    @Override
    public void initialize(ValidBoolean constraintAnnotation) {

        propertyName = constraintAnnotation.propertyName();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        validator.setPropertyName(propertyName);
        validator.setContext(context);

        if (validator.isNull(value)) return false;

        return validator.isBoolean(String.valueOf(value));
    }

}
