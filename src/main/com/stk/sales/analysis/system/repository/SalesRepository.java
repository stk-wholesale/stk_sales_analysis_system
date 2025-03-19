package com.stk.sales.analysis.system.repository;

import com.stk.sales.analysis.system.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Long> {

    // Custom query to find sales by date
    Optional<Sales> findByDate(String date);
}

