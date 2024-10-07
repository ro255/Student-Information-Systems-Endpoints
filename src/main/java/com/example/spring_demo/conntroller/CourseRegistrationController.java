package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.CourseRegistrationDto;
import com.example.spring_demo.models.CourseRegistration;
import com.example.spring_demo.services.CourseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class CourseRegistrationController {

  @Autowired
  private final CourseRegistrationService courseRegistrationService;

  @PostMapping("/courseRegister")
  public ResponseEntity<CourseRegistration> courseRegistration(@RequestBody CourseRegistrationDto courseRegistrationDto) {
    CourseRegistration courseRegistration=courseRegistrationService.courseRegistration(courseRegistrationDto);
     return ResponseEntity.ok(courseRegistration);

  }

  @GetMapping("/register course")
  public ResponseEntity<List<CourseRegistration>> getRegisterCourse() {
    List<CourseRegistration> courseRegistrations = courseRegistrationService.getRegisterCourse();
    return ResponseEntity.ok(courseRegistrations);

  }

  @PutMapping("/courseRegister")
  public ResponseEntity<CourseRegistration> updateCourse(@PathVariable Integer serial_number, @RequestBody CourseRegistrationDto courseRegistrationDto) {
   CourseRegistration courseRegistration = courseRegistrationService.updateCourse(serial_number, courseRegistrationDto);
   return ResponseEntity.ok(courseRegistration);

  }

  @DeleteMapping("/courseRegister/{serial_number}")
  public ResponseEntity<Void> deleteCourse(@PathVariable Integer serial_number) {
  courseRegistrationService.deleteCourse(serial_number);
  return ResponseEntity.ok().build();

  }

}
