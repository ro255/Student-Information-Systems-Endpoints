package com.example.spring_demo.respositories;

import com.example.spring_demo.models.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
