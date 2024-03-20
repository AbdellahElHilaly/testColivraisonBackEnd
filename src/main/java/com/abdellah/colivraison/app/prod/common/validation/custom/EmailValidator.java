package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidEmail;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;


@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private final Validator<String> validator;
    private String propertyName;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        propertyName = constraintAnnotation.propertyName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        validator.setContext(context);
        validator.setPropertyName(propertyName);
        validator.setPattern(EMAIL_PATTERN);


        if (validator.isNull(value)) return false;

        validator.isEmpty(value);

        return validator.isPattern(value, "email", "exemple: test@gmail.com");

    }
}