package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.AccommodationRequestDto;
import com.example.spring_demo.models.Accommodation;
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
  public ResponseEntity<Accommodation> createAccommodation(@RequestBody AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = accommodationService.createAccommodation(accommodationRequestDto);
    return ResponseEntity.ok(accommodation);
  }

  @GetMapping("/get-accommodations")
  public ResponseEntity<List<Accommodation>> getAllAccommodations() {
    List<Accommodation> accommodations = accommodationService.getAllAccommodations();
    return ResponseEntity.ok(accommodations);
  }

  @PutMapping("/accommodations/{accommodationId}")
  public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long accommodationId, @RequestBody AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = accommodationService.updateAccommodation(accommodationId, accommodationRequestDto);
    return ResponseEntity.ok(accommodation);

  }

  @DeleteMapping("/accommodations/{accommodationId}")
  public ResponseEntity<Void> deleteAccommodation(@PathVariable Long accommodationId) {
    accommodationService.deleteAccommodation(accommodationId);
    return ResponseEntity.ok().build();
  }

}
