package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StatusValidator implements ConstraintValidator<ValidateStatus,String> {

  @Override
  public boolean isValid(String Status, ConstraintValidatorContext constraintValidatorContext) {
    List<String> status= Arrays.asList("Paid","Pending","Not Paid");
    return status.contains(Status);
  }
}
