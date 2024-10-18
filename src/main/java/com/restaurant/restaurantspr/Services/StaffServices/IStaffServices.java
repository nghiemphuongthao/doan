package com.restaurant.restaurantspr.Services.StaffServices;

import com.restaurant.restaurantspr.Entities.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffServices {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(Long id);
    Staff createStaff(Staff staff);
    Staff updateStaff(Long id, Staff updatedStaff);
    void deleteStaff(Long id);
}

