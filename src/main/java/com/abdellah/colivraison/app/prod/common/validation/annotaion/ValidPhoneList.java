package com.abdellah.colivraison.app.prod.common.validation.annotaion;

import com.abdellah.colivraison.app.prod.common.validation.custom.IntegerValidator;
import com.abdellah.colivraison.app.prod.common.validation.custom.PhoneListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneListValidator.class)
public @interface ValidPhoneList {

    String message() default "Invalid nom";
    String propertyName() default "name";
    int min() default -1;
    int max() default -1;


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
