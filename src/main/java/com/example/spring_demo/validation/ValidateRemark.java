package com.example.spring_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RemarkValidator.class)

public @interface ValidateRemark {

  public String message() default "Enter a valid remark:It should be either Pass,Fail,Supp,Retake,Disco or Incomplete";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
