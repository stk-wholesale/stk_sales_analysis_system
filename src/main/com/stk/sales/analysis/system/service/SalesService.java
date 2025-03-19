package com.stk.sales.analysis.system.service;

import com.stk.sales.analysis.system.model.Sales;
import com.stk.sales.analysis.system.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    // Get all daily sales records
    public List<Sales> getDailySales() {
        return salesRepository.findAll();
    }

    // Get daily sales by date
    public Sales getDailySalesByDate(String date) {
        Optional<Sales> sales = salesRepository.findByDate(date);
        return sales.orElseThrow(() -> new RuntimeException("Sales not found for date: " + date));
    }

    // Save daily sales record
    public Sales saveDailySales(Sales sales) {
        return salesRepository.save(sales);
    }

    // Edit sales by ID
    public Sales editSalesById(Long id, Sales sales) {
        Optional<Sales> existingSales = salesRepository.findById(id);
        if (existingSales.isPresent()) {
            sales.setId(id);  // Ensure the ID remains the same
            return salesRepository.save(sales);
        } else {
            throw new RuntimeException("Sales record not found for ID: " + id);
        }
    }

    // Delete sales by ID
    public void deleteSalesById(Long id) {
        if (salesRepository.existsById(id)) {
            salesRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sales record not found for ID: " + id);
        }
    }
}
