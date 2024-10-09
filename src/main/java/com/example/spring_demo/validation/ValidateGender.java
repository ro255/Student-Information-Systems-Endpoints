package com.example.spring_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GenderValidator.class)
public @interface ValidateGender {

  public String message() default "Invalid gender:It should be either Male or Female";

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
