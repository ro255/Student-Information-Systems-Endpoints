package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ProgrammeValidator implements ConstraintValidator<ValidateProgramme,String> {

  @Override
  public boolean isValid(String Programme, ConstraintValidatorContext constraintValidatorContext) {
    List<String> programmes = Arrays.asList(
      "Computer Engineering",
      "Computer Science",
      "Software Engineering",
      "Data Science",
      "Information Technology",
      "Telecommunication and Electronics Engineering",
      "Cyber Security Engineering",
      "Mining Engineering",
      "Civil Engineering",
      "Business and Information Technology",
      "Biomedical and Electrical Engineering",
      "Electrical Engineering",
      "Highway Engineering",
      "Business and Accounting",
      "Laboratory Science",
      "Technical Education in Civil Engineering",
      "Technical Education in Mathematics and Physics",
      "Technical Education in Physics and Information Technology",
      "Education in Physics and Chemistry",
      "Mechanical Engineering",
      "Fuel and Oil Engineering"

    );
    return programmes.contains(Programme);
  }
}
