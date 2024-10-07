package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.AccommodationRequestDto;
import com.example.spring_demo.models.Accommodation;
import com.example.spring_demo.respositories.AccommodationRepository;
import com.example.spring_demo.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

  @Autowired
  private AccommodationRepository accommodationRepository;

  @Override
  public Accommodation createAccommodation(AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = new Accommodation();
    accommodation.setResidential(accommodationRequestDto.getResidential());
    accommodation.setAccommodationStatus(accommodationRequestDto.getAccommodationStatus());
    return accommodationRepository.save(accommodation);

  }

  @Override
  public Accommodation updateAccommodation(Long accommodationId, AccommodationRequestDto accommodationRequestDto) {
    Accommodation accommodation = accommodationRepository.findById(accommodationId).orElse(null);
    if (accommodation != null) {
      accommodation.setResidential(accommodationRequestDto.getResidential());
      accommodation.setAccommodationStatus(accommodationRequestDto.getAccommodationStatus());
      return accommodationRepository.save(accommodation);
    } else {
      return null;
    }
  }

  @Override
  public void deleteAccommodation(Long accommodationId) {
    accommodationRepository.deleteById(accommodationId);

  }

  @Override
  public List<Accommodation> getAllAccommodations() {
    return accommodationRepository.findAll();
  }

}
