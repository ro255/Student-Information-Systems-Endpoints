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

  @GetMapping("/register_course")
  public ResponseEntity<List<CourseRegistration>> getRegisterCourse() {
    List<CourseRegistration> courseRegistrations = courseRegistrationService.getRegisterCourse();
    return ResponseEntity.ok(courseRegistrations);

  }
 @PutMapping("/courseRegister/{course_id}")
  public ResponseEntity<CourseRegistration> updateCourseRegistration(@PathVariable Long course_id, @RequestBody CourseRegistrationDto courseRegistrationDto) {
    CourseRegistration courseRegistration= courseRegistrationService.updateCourseRegistration(course_id,courseRegistrationDto);
    return ResponseEntity.ok(courseRegistration);
 }
 @DeleteMapping("/courseRegister/{course_id}")
  public ResponseEntity<Void> deleteCourseRegistration(@PathVariable Long course_id) {
    courseRegistrationService.deleteCourseRegistration(course_id);
    return ResponseEntity.noContent().build();
 }
}
