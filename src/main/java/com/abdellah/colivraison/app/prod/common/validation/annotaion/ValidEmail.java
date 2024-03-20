package com.abdellah.colivraison.app.prod.common.validation.annotaion;

import com.abdellah.colivraison.app.prod.common.validation.custom.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default "Invalid email format";
    String propertyName() default "email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}