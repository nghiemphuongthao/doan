package com.restaurant.restaurantspr.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "RestaurantTable")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;  // Mã bàn

    @Column(nullable = false, length = 50)
    private String name;  // Tên bàn

    @Column(nullable = false)
    private int maxGuests;  // Số lượng khách tối đa

    @Column(length = 255)
    private String description;  // Mô tả bàn

    @Column()
    private boolean status;
    // Constructors, Getters and Setters

    public RestaurantTable() {
    }

    public RestaurantTable(String name, int maxGuests, String description) {
        this.name = name;
        this.maxGuests = maxGuests;
        this.description = description;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}