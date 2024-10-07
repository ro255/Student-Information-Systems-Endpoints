package com.example.spring_demo.respositories;

import com.example.spring_demo.models.CreateInvoice;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional

public interface CreateInvoiceRepository extends JpaRepository<CreateInvoice, Long> {



}
