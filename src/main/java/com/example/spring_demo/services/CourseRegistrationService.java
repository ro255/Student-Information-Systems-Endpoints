package com.example.spring_demo.services;

import com.example.spring_demo.Dto.CourseRegistrationDto;
import com.example.spring_demo.models.CourseRegistration;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public interface CourseRegistrationService {

  CourseRegistration courseRegistration(CourseRegistrationDto courseRegistrationDto);

  List<CourseRegistration> getRegisterCourse();


  CourseRegistration updateCourseRegistration(Long courseId, CourseRegistrationDto courseRegistrationDto);

  void deleteCourseRegistration(Long courseId);

}
