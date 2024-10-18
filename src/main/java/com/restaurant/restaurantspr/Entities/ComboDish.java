package com.restaurant.restaurantspr.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ComboDish")
public class ComboDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comboDishId;

    @ManyToOne
    @JoinColumn(name = "dishId", nullable = false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "comboId", nullable = false)
    private Combo combo;

    // Constructors, Getters, and Setters
    public ComboDish() {
    }

    public ComboDish(Dish dish, Combo combo) {
        this.dish = dish;
        this.combo = combo;
    }

    public Long getComboDishId() {
        return comboDishId;
    }

    public void setComboDishId(Long comboDishId) {
        this.comboDishId = comboDishId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
}
