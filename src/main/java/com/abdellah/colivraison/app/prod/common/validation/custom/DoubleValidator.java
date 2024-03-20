package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidDouble;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DoubleValidator implements ConstraintValidator<ValidDouble, String> {

    private final Validator<String> validator;
    private String propertyName;
    private int min;
    private int max;

    @Override
    public void initialize(ValidDouble constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        propertyName = constraintAnnotation.propertyName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        validator.setContext(context);
        validator.setPropertyName(propertyName);
        validator.setMin(min);
        validator.setMax(max);

        if (validator.isNull(value)) return false;

        validator.isEmpty(value);

        if (!validator.isNumber(value)) return false;

        double valueDouble = Double.parseDouble(value);

        if (validator.isPositive(valueDouble)) {
            if ((min == -1 || valueDouble > min) && (max == -1 || valueDouble < max)) return false;
        }

        if (validator.isBiggerThan(valueDouble)) {
            if (max == -1 || valueDouble < max) return false;
        }

        return validator.isYoungerThan(valueDouble);

    }




}