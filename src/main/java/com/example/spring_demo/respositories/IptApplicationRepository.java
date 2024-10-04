package com.example.spring_demo.respositories;

import com.example.spring_demo.models.IptApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IptApplicationRepository  extends JpaRepository<IptApplication, Long> {

}
