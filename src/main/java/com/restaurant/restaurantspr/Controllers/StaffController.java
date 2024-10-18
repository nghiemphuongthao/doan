package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.Staff;
import com.restaurant.restaurantspr.Services.StaffServices.IStaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final IStaffServices staffServices;

    @Autowired
    public StaffController(IStaffServices staffServices) {
        this.staffServices = staffServices;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffServices.getAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Optional<Staff> staff = staffServices.getStaffById(id);
        return staff.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffServices.createStaff(staff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff updatedStaff) {
        Staff staff = staffServices.updateStaff(id, updatedStaff);
        return staff != null ? ResponseEntity.ok(staff) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffServices.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}

