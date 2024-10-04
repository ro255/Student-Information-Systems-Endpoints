package com.example.spring_demo.respositories;

import com.example.spring_demo.models.InvoiceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InvoiceListRepository extends JpaRepository<InvoiceList, Long> {


}
