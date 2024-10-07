package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.StudentDetailsDto;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.respositories.StudentDetailsRepository;
import com.example.spring_demo.services.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {

  @Autowired
  private final StudentDetailsRepository studentDetailsRepository;

  public StudentDetailsServiceImpl(StudentDetailsRepository studentDetailsRepository) {
    this.studentDetailsRepository = studentDetailsRepository;
  }

  @Override
  public StudentsDetails createDetails(StudentDetailsDto studentDetailsDto) {
    System.out.println("<============================START==========================>");
    System.out.println("<=========================INSIDE createDetails=============================>");

   StudentsDetails studentsDetails = new StudentsDetails();
   studentsDetails.setRegistrationNumber(studentDetailsDto.getRegistrationNumber());
   studentsDetails.setProgramme(studentDetailsDto.getProgramme());
   studentsDetails.setNationality(studentDetailsDto.getNationality());
   studentsDetails.setGender(studentDetailsDto.getGender());
   studentsDetails.setYearOfStudy(studentDetailsDto.getYearOfStudy());
   studentsDetails.setProfile(studentDetailsDto.getProfile());
   studentsDetails.setMobileNo(studentDetailsDto.getMobileNo());
   studentsDetails.setDisability(studentDetailsDto.getDisability());
   studentsDetails.setFormIVIndex(studentDetailsDto.getFormIVIndex());
    // Define the custom date format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    try {
      LocalDate dateOfBirth = LocalDate.parse(studentDetailsDto.getDateOfBirth(), formatter);
      studentsDetails.setDateOfBirth(dateOfBirth);
    } catch (DateTimeParseException e) {
      System.out.println("Error parsing DateOfBirth: " + e.getMessage());
    }


    return  studentDetailsRepository.save(studentsDetails);

  }

  @Override
  public List<StudentsDetails> getAllStudentsDetails() {
    return studentDetailsRepository.findAll();

  }

  @Override
  public StudentsDetails updateStudentDetails(Long student_detail_id, StudentDetailsDto studentDetailsDto) {
    if(student_detail_id ==null) {
      return null;
    }
    StudentsDetails studentsDetails = studentDetailsRepository.findById(student_detail_id).orElse(null);
    if (studentsDetails != null) {
      studentsDetails.setRegistrationNumber(studentDetailsDto.getRegistrationNumber());
      studentsDetails.setProgramme(studentDetailsDto.getProgramme());
      studentsDetails.setNationality(studentDetailsDto.getNationality());
      studentsDetails.setGender(studentDetailsDto.getGender());
      studentsDetails.setYearOfStudy(studentDetailsDto.getYearOfStudy());
      studentsDetails.setProfile(studentDetailsDto.getProfile());
      studentsDetails.setMobileNo(studentDetailsDto.getMobileNo());
      studentsDetails.setDisability(studentDetailsDto.getDisability());
      studentsDetails.setFormIVIndex(studentDetailsDto.getFormIVIndex());
      studentsDetails.setDateOfBirth(LocalDate.parse(studentDetailsDto.getDateOfBirth()));

        return studentDetailsRepository.save(studentsDetails);

    } else {
      return null;
    }

  }

  @Override
  public void deleteStudentDetails(Long student_detail_id) {
    if(student_detail_id ==null) {
      return;
    }

    studentDetailsRepository.deleteById(student_detail_id);

  }
}
