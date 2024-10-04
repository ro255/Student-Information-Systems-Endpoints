package com.example.spring_demo.respositories;

import com.example.spring_demo.models.StudentsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentsDetails, Long> {


//  StudentsDetails findByUsername(String email);

}
