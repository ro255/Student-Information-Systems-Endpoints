package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class GradeValidator implements ConstraintValidator<ValidateGrade,String>{
  @Override
  public boolean isValid(String Grade, ConstraintValidatorContext constraintValidatorContext) {
    List<String> grade= Arrays.asList("A","B","C","SUPP");
    return grade.contains(Grade);
  }
}
