package com.restaurant.restaurantspr.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staffId", nullable = false)
    private Staff staff;  // Reference to Staff entity

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;  // Reference to Customer entity

    // Constructors
    public Invoice() {
    }

    public Invoice(Staff staff, Customer customer) {
        this.staff = staff;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
