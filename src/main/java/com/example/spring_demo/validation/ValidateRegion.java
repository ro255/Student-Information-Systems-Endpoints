package com.example.spring_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RegionValidator.class)
public @interface ValidateRegion {

  public String message() default "Enter a valid region:";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
