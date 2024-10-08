package com.example.spring_demo.respositories;

import com.example.spring_demo.models.CaResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaResultRepository extends JpaRepository<CaResult, Long> {

}
