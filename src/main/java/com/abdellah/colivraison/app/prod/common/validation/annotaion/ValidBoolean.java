package com.abdellah.colivraison.app.prod.common.validation.annotaion;

import com.abdellah.colivraison.app.prod.common.validation.custom.BooleanValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BooleanValidator.class)
public @interface ValidBoolean {
    String message() default "Invalid nom";

    String propertyName() default "name";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
