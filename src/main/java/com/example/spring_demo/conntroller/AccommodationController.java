package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.AccommodationRequestDto;
import com.example.spring_demo.models.Accommodation;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.services.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class AccommodationController {

  @Autowired
  private AccommodationService accommodationService;

  @PostMapping("/accommodations")
  public ResponseEntity<Accommodation> createAccommodation(@RequestBody  AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = accommodationService.createAccommodation(accommodationRequestDto);
    return ResponseEntity.ok(accommodation);

  }

  @GetMapping("/accommodations/{student_detail_id}")
  public ResponseEntity<List<Accommodation>> getAccommodationsByStudent(@PathVariable Long student_detail_id) {
    List<Accommodation> accommodations = accommodationService.getAccommodationByStudentId(student_detail_id);
    return ResponseEntity.ok(accommodations);

  }

  @GetMapping("/get-accommodations/{accommodationId}")
  public ResponseEntity<StudentsDetails> getStudentByAccommodationId(@PathVariable Long accommodationId) {
    StudentsDetails student = accommodationService.getStudentByAccommodationId(accommodationId);
    return ResponseEntity.ok(student);

//    List<Accommodation> accommodations = accommodationService.getStudentByAccommodationId();
//    return ResponseEntity.ok(accommodations);

  }

  @PutMapping("/accommodations/{accommodationId}")
  public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long accommodationId, @RequestBody  AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = accommodationService.updateAccommodation(accommodationId, accommodationRequestDto);
    return ResponseEntity.ok(accommodation);

  }

  @DeleteMapping("/accommodations/{accommodationId}")
  public ResponseEntity<Void> deleteAccommodation(@PathVariable Long accommodationId) {
    accommodationService.deleteAccommodation(accommodationId);
    return ResponseEntity.ok().build();

  }

}
