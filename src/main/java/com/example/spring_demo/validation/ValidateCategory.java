package com.example.spring_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CategoryValidator.class)
public @interface ValidateCategory {
  public String message() default "Enter a valid category: It should be either NHIF,Tuition Fee,Accommodation,Direct Cost";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
