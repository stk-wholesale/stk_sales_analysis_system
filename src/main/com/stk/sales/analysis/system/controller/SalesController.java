package com.stk.sales.analysis.system.controller;

import com.stk.sales.analysis.system.model.Sales;
import com.stk.sales.analysis.system.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/daily")
    public List<Sales> getDailySales() {
        return salesService.getDailySales();
    }

    @GetMapping("/daily/{date}")
    public Sales getDailySalesByDate(@PathVariable String date) {
        return salesService.getDailySalesByDate(date);
    }

    @PostMapping("/daily")
    public Sales saveDailySales(@RequestBody Sales sales) {
        return salesService.saveDailySales(sales);
    }

    @PutMapping("/daily/{id}")
    public Sales editSalesById(@PathVariable Long id, @RequestBody Sales sales) {
        return salesService.editSalesById(id, sales);
    }

    @DeleteMapping("/daily/{id}")
    public void deleteSalesById(@PathVariable Long id) {
        salesService.deleteSalesById(id);
    }
}
