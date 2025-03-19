package com.stk.sales.analysis.system.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {

    @Id
    private Long id;
    private String date;
    private Double totalSales;

    // Constructors
    public Sales() {}

    public Sales(Long id, String date, Double totalSales) {
        this.id = id;
        this.date = date;
        this.totalSales = totalSales;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }
}

