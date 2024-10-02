package com.example.spring_demo.respositories;

import com.example.spring_demo.models.NhifApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhifApplicationRepository extends JpaRepository<NhifApplication, Long> {

}
