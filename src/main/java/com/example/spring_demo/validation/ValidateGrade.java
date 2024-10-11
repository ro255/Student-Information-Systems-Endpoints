package com.example.spring_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GradeValidator.class)
public @interface ValidateGrade {

  public String message() default "Enter the valid grade:It should be either A,B,C or SUPP";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
