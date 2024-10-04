package com.example.spring_demo.conntroller;

import com.example.spring_demo.auth.AuthenticationResponse;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.StudentDetailsRepository;
import com.example.spring_demo.services.StudentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class StudentsDetailsController {

  private final StudentDetailsService studentDetailsService;
  private final StudentDetailsRepository studentDetailsRepository;

  @PostMapping("/studentDetails")
  public ResponseEntity <AuthenticationResponse> studentDetails(@RequestBody StudentsDetailsRequest request) {

    try{
      AuthenticationResponse authenticationResponse= studentDetailsService.studentDetails(request);
      ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>(
        HttpStatus.OK.value(),
        "The details of student is sent successfully",
        authenticationResponse
      );
      return ResponseEntity.ok(apiResponse.getData());

    } catch (Exception e) {
      ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The details of student not found",
        null
      );
      return ResponseEntity.ok(apiResponse.getData());
    }


  }


  @GetMapping("/details_students")
  public ResponseEntity <List<StudentsDetails>> getStudentDetails() {

    try{
  List<StudentsDetails> studentsDetailsList = studentDetailsRepository.findAll();
  ApiResponse<List<StudentsDetails>> apiResponse = new ApiResponse<>(
    HttpStatus.OK.value(),
    "The students details retrived successfully",
    studentsDetailsList
  );
  return ResponseEntity.ok(apiResponse.getData());

    } catch (Exception e) {
      ApiResponse<List<StudentsDetails>> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The students details is not found",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }


  @PutMapping("/studentDetails/{StuDetailId}")
  public ResponseEntity <AuthenticationResponse> updateStudentDetails(@PathVariable Long StuDetailId, @RequestBody StudentsDetailsRequest request) {
    try{
     StudentsDetails studentsDetails= studentDetailsRepository.findById(StuDetailId).orElseThrow(() ->
       new NoSuchElementException("The student details not found: " + StuDetailId));

          studentsDetails.setDisability(request.getDisability());
          studentsDetails.setGender(request.getGender());
          studentsDetails.setProfile(request.getProfile());
          studentsDetails.setProgramme(request.getProgramme());
          studentsDetails.setMobileNo(request.getMobileNo());
          studentsDetails.setDateOfBirth(request.getDateOfBirth());
          studentsDetails.setRegistrationNumber(request.getRegistrationNumber());
          studentsDetails.setFormIVIndex(request.getFormIVIndex());
          studentsDetails.setYearOfStudy(request.getYearOfStudy());
          studentsDetails.setNationality(request.getNationality());

          studentDetailsRepository.save(studentsDetails);

          AuthenticationResponse response = new AuthenticationResponse();
          ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>(
            HttpStatus.OK.value(),
            "The student details submitted successfully",
             response
          );
          return ResponseEntity.ok(apiResponse.getData());

    } catch (Exception e) {
      ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The students details was not submitted successfully ",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }

  @DeleteMapping("/studentDetails/{StuDetailId}")
  public ResponseEntity <Void> deleteStudentDetails(@PathVariable Long StuDetailId) {
    try{
      StudentsDetails studentsDetails= studentDetailsRepository.findById(StuDetailId).orElseThrow(() ->
        new NoSuchElementException("The student details not found: " + StuDetailId));
          studentDetailsRepository.delete(studentsDetails);

          ApiResponse<Void> apiResponse = new ApiResponse<>(
            HttpStatus.OK.value(),
            "The student details was deleted successfully",
            null
          );
          return ResponseEntity.ok(apiResponse.getData());
    }  catch (Exception e) {
      ApiResponse<Void> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The student details was not deleted:",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

  }

}
