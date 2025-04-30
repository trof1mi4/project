package com.urfu.project.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.lang.annotation.*;

@Size(min = 8, message = "Пароль должен быть не короче 8 символов")
@Pattern(
        regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*]).*$",
        message = "Пароль должен содержать хотя бы одну цифру и спецсимвол"
)
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {
    String message() default "Некорректный пароль";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
