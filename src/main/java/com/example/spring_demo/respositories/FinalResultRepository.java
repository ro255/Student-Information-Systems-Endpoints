package com.example.spring_demo.respositories;

import com.example.spring_demo.models.FinalResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FinalResultRepository extends JpaRepository<FinalResult, Long> {

}
