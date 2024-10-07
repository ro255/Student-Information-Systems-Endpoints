package com.example.spring_demo.respositories;

import com.example.spring_demo.models.MyFullProfile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
@Transactional

public interface MyFullProfileRepository extends JpaRepository<MyFullProfile, BigInteger> {


}
