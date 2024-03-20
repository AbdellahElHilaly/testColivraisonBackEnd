package com.abdellah.colivraison.app.prod.common.validation.annotaion;

import com.abdellah.colivraison.app.prod.common.validation.custom.UUIDValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UUIDValidator.class)
public @interface ValidUUID {
    String message() default "Invalid UUID";
    String propertyName() default "uuid";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
