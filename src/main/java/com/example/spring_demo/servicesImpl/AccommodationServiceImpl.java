package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.AccommodationRequestDto;
import com.example.spring_demo.models.Accommodation;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.respositories.AccommodationRepository;
import com.example.spring_demo.respositories.StudentDetailsRepository;
import com.example.spring_demo.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

  @Autowired
  private StudentDetailsRepository studentDetailsRepository;

  @Autowired
  private AccommodationRepository accommodationRepository;

  public List<Accommodation> getAccommodationByStudentId(Long student_detail_id) {
    StudentsDetails studentsDetails = studentDetailsRepository.findById(student_detail_id)
      .orElseThrow(() -> new RuntimeException("Student not found"));
    return accommodationRepository.findByStudentsDetails(studentsDetails);
  }

  public StudentsDetails getStudentByAccommodationId(Long accommodationId) {
    Accommodation accommodation = accommodationRepository.findById(accommodationId)
      .orElseThrow(() -> new RuntimeException("Accommodation not found"));
    return accommodation.getStudentsDetails();

  }

  @Override
  public Accommodation createAccommodation(AccommodationRequestDto accommodationRequestDto) {
//StudentsDetails student = studentDetailsRepository.findById(student_detail_id).orElseThrow(() -> new RuntimeException("Student not found"));

    Accommodation accommodation = new Accommodation();
    accommodation.setResidential(accommodationRequestDto.getResidential());
    accommodation.setAccommodationStatus(accommodationRequestDto.getAccommodationStatus());

//accommodation.setStudentsDetails(student);
    return accommodationRepository.save(accommodation);

  }

  @Override
  public Accommodation updateAccommodation(Long accommodationId, AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = accommodationRepository.findById(accommodationId).orElse(null);
    System.out.println(accommodation);
    if (accommodation != null) {
      accommodation.setResidential(accommodationRequestDto.getResidential());
      accommodation.setAccommodationStatus(accommodationRequestDto.getAccommodationStatus());

      System.out.println(accommodation);
      System.out.println("====================================================END========================================================");
      return accommodationRepository.save(accommodation);
    } else {
      return null;
    }
  }

  @Override
  public void deleteAccommodation(Long accommodationId) {
    accommodationRepository.deleteById(accommodationId);

  }
//
//  @Override
//  public List<Accommodation> getAllAccommodations() {
//    return accommodationRepository.findAll();
//  }

}
