package com.abdellah.colivraison.app.prod.common.validation.custom;

import com.abdellah.colivraison.app.prod.common.validation.annotaion.ValidPhoneList;
import com.abdellah.colivraison.app.prod.common.validation.helper.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhoneListValidator implements ConstraintValidator<ValidPhoneList, List<String>> {
    private final Validator<List<String>> validator;
    private String propertyName;

    @Override
    public void initialize(ValidPhoneList constraintAnnotation) {
        propertyName = constraintAnnotation.propertyName();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        validator.setPropertyName(propertyName);
        validator.setContext(context);
        validator.setLength(10);

        if (validator.isNull(value)) return false;
        if (validator.isEmptyList(value)) return false;

        boolean result = validator.isEmptyItems(value);

        if (!validator.isLengthItemsEqual(value)) result = false;
        if (!validator.isPhoneItems(value)) result = false;
        if(!validator.isDuplicateItems(value)) result = false;
        if(!validator.isNumberItems(value)) result = false;
        if(!validator.isIntegerItems(value)) result = false;

        return result;

    }
}
