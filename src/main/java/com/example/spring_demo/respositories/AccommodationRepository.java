package com.example.spring_demo.respositories;

import com.example.spring_demo.models.Accommodation;
import com.example.spring_demo.models.StudentsDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

  List<Accommodation> findByStudentsDetails(StudentsDetails studentsDetails);

}


