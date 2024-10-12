package com.example.spring_demo.services;

import com.example.spring_demo.Dto.AccommodationRequestDto;
import com.example.spring_demo.models.Accommodation;
import com.example.spring_demo.models.StudentsDetails;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public interface AccommodationService {

  List<Accommodation> getAccommodationByStudentId(Long student_detail_id);
  StudentsDetails getStudentByAccommodationId(Long accommodationId);
  Accommodation createAccommodation(Long student_detail_id, AccommodationRequestDto accommodationRequestDto); // Modified
  Accommodation updateAccommodation(Long accommodationId, AccommodationRequestDto accommodationRequestDto);
  void deleteAccommodation(Long accommodationId);
}

