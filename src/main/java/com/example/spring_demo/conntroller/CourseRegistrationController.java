package com.example.spring_demo.conntroller;

import com.example.spring_demo.models.CourseRegistration;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.CourseRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth/v1/courseRegister")
@RequiredArgsConstructor

public class CourseRegistrationController {

  private final CourseRegistrationRepository courseRegistrationRepository;


  @PostMapping
  public ResponseEntity<?> courseRegistration(@RequestBody CourseRegistrationRequest request) {
     return ResponseEntity.ok().build();

  }

  @GetMapping("/register course")
  public ResponseEntity<List<CourseRegistration>> registerCourse() {
    List<CourseRegistration> courseRegistrations = courseRegistrationRepository.findAll();
    if (courseRegistrations.isEmpty()) {
      throw  new RuntimeException("Course Registration Not Found");
    } try{
      ApiResponse<List<CourseRegistration>> apiResponse = new ApiResponse<>(
        HttpStatus.OK.value(),
        "Course successfully registered",
        courseRegistrations
      );
    } catch (Exception e) {
      ApiResponse<List<CourseRegistration>> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "Course not registered",
        null
      );
    }
    return ResponseEntity.ok().body(courseRegistrations);

  }


  @PatchMapping("/courseRegister")
  public ResponseEntity<List<CourseRegistration>> updateCourse(@PathVariable Integer serial_number, @RequestBody CourseRegistrationRequest request) {
   try {
     CourseRegistration courseRegistration= courseRegistrationRepository.findById(serial_number).orElseThrow(() ->
       new RuntimeException("Course Registration Not Found"));
     courseRegistration.setCourse_code(request.getCourse_code());
     courseRegistration.setCourse_name(request.getCourse_name());
     courseRegistration.setCourse_code(request.getCourse_code());
     courseRegistration.setStatus(request.getStatus());
     courseRegistrationRepository.save(courseRegistration);

   }

   catch (Exception e) {
     ApiResponse<List<CourseRegistration>> apiResponse = new ApiResponse<>(
       HttpStatus.BAD_REQUEST.value(),
       "Course Update failed",
       null
     );
   }
    return ResponseEntity.ok().body(courseRegistrationRepository.findAll());
  }


  @DeleteMapping("/courseRegister/{serial_number}")
  public ResponseEntity<?> deleteCourse(@PathVariable Integer serial_number) {
    try {
      CourseRegistration courseRegistration =courseRegistrationRepository.findById(serial_number).orElseThrow(() ->
        new RuntimeException("Course Registration Not Found with:" + serial_number));
      courseRegistrationRepository.delete(courseRegistration);

      ApiResponse<Void> apiResponse = new ApiResponse<>(
        HttpStatus.OK.value(),
        "course deleted successfully",
        null
      );

    } catch (Exception e) {
      ApiResponse<Void> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "course not found",
        null
      );
    }
    return ResponseEntity.ok().build();
  }

}
