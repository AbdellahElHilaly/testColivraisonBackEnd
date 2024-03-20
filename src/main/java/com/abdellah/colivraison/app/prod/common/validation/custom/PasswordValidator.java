package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidPassword;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private final Validator<String> validator;
    private String propertyName;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("(?=.*\\d)(?=.*[a-zA-Z])(?=.*[@#$%^&*()_+!]).{8,}");

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        propertyName = constraintAnnotation.propertyName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        validator.setContext(context);
        validator.setPropertyName(propertyName);
        validator.setPattern(PASSWORD_PATTERN);
        validator.setMinLength(8);

        if (validator.isNull(value)) return false;

        validator.isEmpty(value);
        validator.isTallerThan(value);

        return validator.isPattern(value, "password",
                "doit contenir au moins 8 caractères, une lettre majuscule, un chiffre et un caractère spécial");
    }
}