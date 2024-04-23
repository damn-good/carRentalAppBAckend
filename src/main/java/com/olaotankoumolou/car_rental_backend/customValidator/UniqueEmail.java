package com.olaotankoumolou.car_rental_backend.customValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default "ALREADY_USED_EMAIL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
