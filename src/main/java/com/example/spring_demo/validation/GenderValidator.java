package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class GenderValidator implements ConstraintValidator<ValidateGender,String> {

  @Override
  public boolean isValid(String Gender, ConstraintValidatorContext constraintValidatorContext) {
    List<String> gender= Arrays.asList("Female","Male");
    return gender.contains(Gender);
  }

}
