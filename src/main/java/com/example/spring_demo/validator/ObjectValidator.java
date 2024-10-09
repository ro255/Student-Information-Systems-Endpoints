package com.example.spring_demo.validator;

import com.example.spring_demo.models.StudentsDetails;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator {

  private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = validatorFactory.getValidator();
  public Set<Object> validate(StudentsDetails objectToValidate) {
    Set<ConstraintViolation<StudentsDetails>> violations = validator.validate(objectToValidate);

    if (!violations.isEmpty()) {
        return violations
        .stream()
        .map(ConstraintViolation::getMessage)
        .collect(Collectors.toSet());

    }
    return Collections.emptySet();
  }
}
