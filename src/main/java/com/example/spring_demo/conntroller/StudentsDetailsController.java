package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.StudentDetailsDto;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.services.StudentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class StudentsDetailsController {

  private StudentDetailsService studentDetailsService;

  @Autowired
  public void StudentDetailsController(StudentDetailsService studentDetailsService) {
    this.studentDetailsService = studentDetailsService;
  }

  @PostMapping("/studentDetails/{userId}")
  public ResponseEntity<Users> createDetails(@PathVariable Long userId, @RequestBody StudentDetailsDto studentDetailsDto) {
    if (studentDetailsDto == null) {
      return ResponseEntity.badRequest().body(null);
    }

    // Call the service to create student details and associate with the user
    StudentsDetails studentsDetails = studentDetailsService.createDetails(studentDetailsDto, userId);

    return ResponseEntity.ok(studentsDetails.getUsers());
  }

  @GetMapping("/details_students")
  public ResponseEntity<List<StudentsDetails>> getStudentDetails() {
    List<StudentsDetails> studentsDetails = studentDetailsService.getAllStudentsDetails();
    return ResponseEntity.ok(studentsDetails);

  }

  @PutMapping("/studentDetails/{student_detail_id}")
  public ResponseEntity<StudentsDetails> updateStudentDetails(@PathVariable Long student_detail_id, @RequestBody StudentDetailsDto studentDetailsDto) {
    StudentsDetails studentsDetails = studentDetailsService.updateStudentDetails(student_detail_id, studentDetailsDto);
    return ResponseEntity.ok(studentsDetails);

  }

  @DeleteMapping("/studentDetails/{student_detail_id}")
  public ResponseEntity<Void> deleteStudentDetails(@PathVariable Long student_detail_id) {
    studentDetailsService.deleteStudentDetails(student_detail_id);
    return ResponseEntity.ok().build();
  }

}
