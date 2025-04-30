package com.urfu.project.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {
    String message() default "Номер телефона должен начинаться с '+' и содержать только цифры";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
