package com.example.spring_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class RegionValidator implements ConstraintValidator<ValidateRegion, String> {

  @Override
  public boolean isValid(String Region, ConstraintValidatorContext constraintValidatorContext) {
    List<String> regions= Arrays.asList(
      "Dodoma",
      "Mwanza",
      "Moshi",
      "Mbeya",
      "Arusha",
      "Dar-es-Salaam",
      "Kilimanjaro",
      "Shinyanga",
      "Kigoma",
      "Geita",
      "Songea",
      "Manyara",
      "Tanga",
      "Musoma",
      "Lindi",
      "Bukoba",
      "Mpanda",
      "Tabora"

    );
    return regions.contains(Region);
  }
}
