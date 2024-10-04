package com.example.spring_demo.conntroller;

import com.example.spring_demo.auth.AuthenticationResponse;
import com.example.spring_demo.models.Accommodation;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.AccommodationRepository;
import com.example.spring_demo.services.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor


public class AccommodationController {


  private final AccommodationService accommodationService;
  private final AccommodationRepository accommodationRepository;

  @PostMapping("/accommodation")
  public ResponseEntity<AuthenticationResponse> application(@RequestBody AccommodationRequest request) {
    try {
      AuthenticationResponse  response= accommodationService.application(request);
      ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
        HttpStatus.OK.value(),
        "Application Successfully",
        response
      );
      return ResponseEntity.ok(apiResponse.getData());
    } catch (Exception e) {
      ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "Application failed",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }


  }


  @GetMapping("/applications")
  public ResponseEntity<?> getAllApplications() {
    List<Accommodation> accommodations = accommodationRepository.findAll();
    if(accommodations.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No accommodations found");
    }

    try {
      ApiResponse<List<Accommodation>> apiResponse= new ApiResponse<>(
        HttpStatus.OK.value(),
        "Applications for accommodation retrieved successfully ",
        accommodations
      );
    } catch(Exception e) {
      ApiResponse<List<Accommodation>> apiResponse= new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "No Applications found",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

 return ResponseEntity.ok(accommodations);
  }


  @PutMapping("/accommodation/{accommodationId}")
  public ResponseEntity<?> updateAccommodation(@PathVariable Long accommodationId,  @RequestBody AccommodationRequest request) {
    try {
      Accommodation accommodation= accommodationRepository.findById(accommodationId).get();
      accommodation.setResidential(request.getResidential());
      accommodation.setAccommodation_status(request.getAccommodation_status());
      accommodationRepository.save(accommodation);

      ApiResponse<Accommodation> apiResponse= new ApiResponse<>(
        HttpStatus.OK.value(),
        "Application for accommodation submitted successfully",
        accommodation
      );
      return ResponseEntity.ok(apiResponse.getData());

    } catch(Exception e) {
      ApiResponse<Accommodation> apiResponse= new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "Application for accommodation was not success",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accommodationRepository.findById(accommodationId).get());
    }

  }


  @DeleteMapping("/accommodation/{accommodationId}")
  public ResponseEntity<?> deleteAccommodation(@PathVariable Long accommodationId) {
    try{
      Accommodation accommodation= accommodationRepository.findById(accommodationId).get();
      accommodationRepository.delete(accommodation);
      ApiResponse<Accommodation> apiResponse= new ApiResponse<>(
        HttpStatus.OK.value(),
        "The Applications for accommodations was deleted successfully",
        accommodation
      );
      return ResponseEntity.ok(apiResponse.getData());
    } catch(Exception e) {
      ApiResponse<Accommodation> apiResponse= new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "Failed to delete the applications for accommodation:",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

  }

}
