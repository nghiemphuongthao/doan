package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.ComboDish;
import com.restaurant.restaurantspr.Services.ComboDishServices.IComboDishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/combo-dishes")
public class ComboDishController {

    private final IComboDishServices comboDishServices;

    @Autowired
    public ComboDishController(IComboDishServices comboDishServices) {
        this.comboDishServices = comboDishServices;
    }

    @GetMapping
    public List<ComboDish> getAllComboDishes() {
        return comboDishServices.getAllComboDishes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComboDish> getComboDishById(@PathVariable Long id) {
        Optional<ComboDish> comboDish = comboDishServices.getComboDishById(id);
        return comboDish.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComboDish createComboDish(@RequestBody ComboDish comboDish) {
        return comboDishServices.createComboDish(comboDish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComboDish> updateComboDish(@PathVariable Long id, @RequestBody ComboDish updatedComboDish) {
        ComboDish comboDish = comboDishServices.updateComboDish(id, updatedComboDish);
        return (comboDish != null) ? ResponseEntity.ok(comboDish) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComboDish(@PathVariable Long id) {
        if (comboDishServices.getComboDishById(id).isPresent()) {
            comboDishServices.deleteComboDish(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/combo/{comboId}")
    public List<ComboDish> getComboDishesByComboId(@PathVariable Long comboId) {
        return comboDishServices.getComboDishesByComboId(comboId);
    }

    @GetMapping("/dish/{dishId}")
    public List<ComboDish> getComboDishesByDishId(@PathVariable Long dishId) {
        return comboDishServices.getComboDishesByDishId(dishId);
    }
}