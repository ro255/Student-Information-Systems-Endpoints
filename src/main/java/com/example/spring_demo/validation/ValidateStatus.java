package com.example.spring_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StatusValidator.class)

public @interface ValidateStatus {

  public String message() default "Enter a valid status";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
