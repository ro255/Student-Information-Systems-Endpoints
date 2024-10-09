package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<ValidateCategory,String> {

  @Override
  public boolean isValid(String Category, ConstraintValidatorContext constraintValidatorContext) {
    List<String> category= Arrays.asList("NHIF","Tuition Fee","Accommodation","Direct Cost");
    return category.contains(Category);
  }
}
