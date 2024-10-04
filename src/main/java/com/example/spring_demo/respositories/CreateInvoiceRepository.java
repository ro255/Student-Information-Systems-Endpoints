package com.example.spring_demo.respositories;

import com.example.spring_demo.models.CreateInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CreateInvoiceRepository extends JpaRepository<CreateInvoice, Long> {



}
