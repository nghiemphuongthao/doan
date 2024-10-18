package com.restaurant.restaurantspr.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderTable")
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoiceId", nullable = false)
    private Invoice invoice;  // Reference to Invoice entity

    @ManyToOne
    @JoinColumn(name = "tableId", nullable = false)
    private RestaurantTable table;  // Reference to Table entity

    // Constructors
    public OrderTable() {
    }

    public OrderTable(Invoice invoice, RestaurantTable table) {
        this.invoice = invoice;
        this.table = table;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }
}
