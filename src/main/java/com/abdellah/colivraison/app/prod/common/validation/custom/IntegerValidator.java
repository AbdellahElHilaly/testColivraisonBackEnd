package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidInteger;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class IntegerValidator implements ConstraintValidator<ValidInteger, String> {

    private int min;
    private int max;
    private String propertyName;


    private final Validator<String> validator;

    @Override
    public void initialize(ValidInteger constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        propertyName = constraintAnnotation.propertyName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        validator.setContext(context);
        validator.setMin(min);
        validator.setMax(max);
        validator.setPropertyName(propertyName);


        if (validator.isNull(value)) return false;

        if (!validator.isNumber(value)) return false;

        validator.isEmpty(value);
        validator.isInteger(value, context);

        int valueDouble = Double.valueOf(value).intValue();

        if (validator.isPositive(Double.valueOf(value))) {
            if ((min == -1 || valueDouble > min) && (max == -1 || valueDouble < max)) return false;
        }


        if (validator.isBiggerThan(Double.valueOf(value))) {
            if (max == -1 || valueDouble < max) return false;
        }

        return validator.isYoungerThan(Double.valueOf(value));

    }


}