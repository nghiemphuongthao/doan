package com.restaurant.restaurantspr.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDish")
public class OrderDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoiceId", nullable = false)
    private Invoice invoice;  // Reference to Invoice entity

    @ManyToOne
    @JoinColumn(name = "dishId", nullable = false)
    private Dish dish;  // Reference to Dish entity

    @Column(nullable = false)
    private Long quantity;  // Quantity of dish items

    // Constructors
    public OrderDish() {
    }

    public OrderDish(Invoice invoice, Dish dish, Long quantity) {
        this.invoice = invoice;
        this.dish = dish;
        this.quantity = quantity;
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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
