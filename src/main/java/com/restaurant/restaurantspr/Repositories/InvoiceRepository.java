package com.restaurant.restaurantspr.Repositories;

import com.restaurant.restaurantspr.Entities.Invoice;
import com.restaurant.restaurantspr.Services.InvoiceServices.IInvoiceServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomer_CustomerId(Long customerId);
    List<Invoice> findByStaff_Id(Long staffId);;
}
