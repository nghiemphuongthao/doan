package com.restaurant.restaurantspr.Services.InvoiceServices;

import com.restaurant.restaurantspr.Entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface IInvoiceServices {
        List<Invoice> getAllInvoices();
        Optional<Invoice> getInvoiceById(Long id);
        Invoice createInvoice(Invoice invoice);
        Invoice updateInvoice(Long id, Invoice updatedInvoice);
        void deleteInvoice(Long id);
        List<Invoice> getInvoicesByCustomerId(Long customerId);
        List<Invoice> getInvoicesByStaffId(Long staffId);
}
