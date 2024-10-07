package com.example.spring_demo.services;

import com.example.spring_demo.Dto.StudentDetailsDto;
import com.example.spring_demo.models.StudentsDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentDetailsService {

  StudentsDetails createDetails(StudentDetailsDto studentDetailsDto);

  List<StudentsDetails> getAllStudentsDetails();

  StudentsDetails updateStudentDetails(Long student_detail_id, StudentDetailsDto studentDetailsDto);

  void deleteStudentDetails(Long student_detail_id);

}
