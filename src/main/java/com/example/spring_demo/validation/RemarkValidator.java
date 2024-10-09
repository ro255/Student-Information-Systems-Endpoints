package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class RemarkValidator implements ConstraintValidator<ValidateRemark, String> {

  @Override
  public boolean isValid(String Remark, ConstraintValidatorContext constraintValidatorContext) {
    List<String> remark= Arrays.asList("PASS","FAIL","SUPP","INCOMPLETE","DISCO","RETAKE");
    return remark.contains(Remark);
  }
}
