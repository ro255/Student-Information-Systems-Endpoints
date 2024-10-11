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

  Accommodation createAccommodation(AccommodationRequestDto accommodationRequestDto);

  Accommodation updateAccommodation(Long accommodationId, AccommodationRequestDto accommodationRequestDto);

  void deleteAccommodation(Long accommodationId);

  StudentsDetails getStudentByAccommodationId(Long accommodationId);

  List<Accommodation> getAccommodationByStudentId(Long studentDetailId);

}
