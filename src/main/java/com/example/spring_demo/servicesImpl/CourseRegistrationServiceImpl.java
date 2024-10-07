package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.CourseRegistrationDto;
import com.example.spring_demo.models.CourseRegistration;
import com.example.spring_demo.respositories.CourseRegistrationRepository;
import com.example.spring_demo.services.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

  @Autowired
  private CourseRegistrationRepository courseRegistrationRepository;

  @Override
  public CourseRegistration courseRegistration(CourseRegistrationDto courseRegistrationDto) {
    CourseRegistration courseRegistration = new CourseRegistration();
    courseRegistration.setCourse_name(courseRegistrationDto.getCourse_name());
    courseRegistration.setCourse_code(courseRegistrationDto.getCourse_code());
    courseRegistration.setUnit(courseRegistrationDto.getUnit());
    courseRegistration.setStatus(courseRegistrationDto.getStatus());
     return courseRegistrationRepository.save(courseRegistration);

  }

  @Override
  public List<CourseRegistration> getRegisterCourse() {
    return  courseRegistrationRepository.findAll();

  }

  @Override
  public CourseRegistration updateCourse(Integer serialNumber, CourseRegistrationDto courseRegistrationDto) {
    CourseRegistration courseRegistration = courseRegistrationRepository.findById(serialNumber).orElse(null);
    if(courseRegistration != null){
      courseRegistration.setCourse_code(courseRegistrationDto.getCourse_code());
      courseRegistration.setCourse_name(courseRegistrationDto.getCourse_name());
      courseRegistration.setUnit(courseRegistrationDto.getUnit());
      courseRegistration.setStatus(courseRegistrationDto.getStatus());
      return courseRegistrationRepository.save(courseRegistration);
    } else {
      return null;
    }

  }

  @Override
  public void deleteCourse(Integer serialNumber) {
    courseRegistrationRepository.deleteById(serialNumber);
  }

}
