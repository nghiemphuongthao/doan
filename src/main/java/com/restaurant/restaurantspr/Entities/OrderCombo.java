package com.restaurant.restaurantspr.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderCombo")
public class OrderCombo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoiceId", nullable = false)
    private Invoice invoice;  // Reference to Invoice entity

    @ManyToOne
    @JoinColumn(name = "comboId", nullable = false)
    private Combo combo;  // Reference to Combo entity

    @Column(nullable = false)
    private Long quantity;  // Quantity of combo items

    // Constructors
    public OrderCombo() {
    }

    public OrderCombo(Invoice invoice, Combo combo, Long quantity) {
        this.invoice = invoice;
        this.combo = combo;
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

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
