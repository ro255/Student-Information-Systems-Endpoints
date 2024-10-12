package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.StudentDetailsDto;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.respositories.StudentDetailsRepository;
import com.example.spring_demo.respositories.UsersRepository;
import com.example.spring_demo.services.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public  class StudentDetailsServiceImpl implements StudentDetailsService {

  @Autowired
  private final StudentDetailsRepository studentDetailsRepository;

  @Autowired
  private final UsersRepository usersRepository;

  public StudentDetailsServiceImpl(StudentDetailsRepository studentDetailsRepository, UsersRepository usersRepository) {
    this.studentDetailsRepository = studentDetailsRepository;
    this.usersRepository = usersRepository;
  }

  @Override
  public StudentsDetails createDetails(StudentDetailsDto studentDetailsDto, Long userId) {
    System.out.println("<============================START==========================>");
    System.out.println("<=========================INSIDE createDetails=============================>");

// Fetch the user entity using userId
    Users user = usersRepository.findById(userId)
      .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

    StudentsDetails studentsDetails = new StudentsDetails();
    // Set the student details fields
    studentsDetails.setRegistrationNumber(studentDetailsDto.getRegistrationNumber());
    studentsDetails.setProgramme(studentDetailsDto.getProgramme());
    studentsDetails.setNationality(studentDetailsDto.getNationality());
    studentsDetails.setGender(studentDetailsDto.getGender());
    studentsDetails.setYearOfStudy(studentDetailsDto.getYearOfStudy());
    studentsDetails.setProfile(studentDetailsDto.getProfile());
    studentsDetails.setMobileNo(studentDetailsDto.getMobileNo());
    studentsDetails.setDisability(studentDetailsDto.getDisability());
    studentsDetails.setFormIVIndex(studentDetailsDto.getFormIVIndex());
    studentsDetails.setDateOfBirth(studentDetailsDto.getDateOfBirth());

    // Associate the user with the student details
    studentsDetails.setUsers(user);

    return studentDetailsRepository.save(studentsDetails);

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
      studentsDetails.setDateOfBirth(studentDetailsDto.getDateOfBirth());

      System.out.println(studentDetailsDto);
      System.out.println(studentsDetails);
      System.out.println("============================================END=================================================");

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
