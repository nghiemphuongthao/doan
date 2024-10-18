package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.Combo;
import com.restaurant.restaurantspr.Services.ComboServices.ComboServices;
import com.restaurant.restaurantspr.Services.ComboServices.IComboServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combos")
public class ComboController {

    private final IComboServices comboServices;

    @Autowired
    public ComboController(ComboServices comboService) {
        this.comboServices = comboService;
    }

    @PostMapping
    public ResponseEntity<Combo> createCombo(@RequestBody Combo combo) {
        Combo createdCombo = comboServices.createCombo(combo);
        return ResponseEntity.ok(createdCombo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combo> getComboById(@PathVariable("id") Long id) {
        Combo combo = comboServices.getComboById(id);
        return ResponseEntity.ok(combo);
    }

    @GetMapping
    public ResponseEntity<List<Combo>> getAllCombos() {


        List<Combo> combos = comboServices.getAllCombos();
        return ResponseEntity.ok(combos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combo> updateCombo(@PathVariable("id") Long id, @RequestBody Combo combo) {
        Combo updatedCombo = comboServices.updateCombo(id, combo);
        return updatedCombo != null ? ResponseEntity.ok(updatedCombo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCombo(@PathVariable("id") Long id) {
        comboServices.deleteCombo(id);
        return ResponseEntity.noContent().build();
    }
}