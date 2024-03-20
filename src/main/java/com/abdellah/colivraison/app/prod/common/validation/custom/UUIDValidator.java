package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidUUID;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UUIDValidator implements ConstraintValidator<ValidUUID, String> {
    private String propertyName;
    private final Validator<String> validator;

    @Override
    public void initialize(ValidUUID constraintAnnotation) {
        propertyName = constraintAnnotation.propertyName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        validator.setPropertyName(propertyName);
        validator.setContext(context);
        validator.setLength(36);


        if (validator.isNull(value)) return false;

        validator.isEmpty(value);
        validator.isLengthEqual(value);
        return validator.isUUidFormat(value);

    }

}
