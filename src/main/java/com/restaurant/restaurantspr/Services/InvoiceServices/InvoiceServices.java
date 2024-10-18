package com.restaurant.restaurantspr.Services.InvoiceServices;

import com.restaurant.restaurantspr.Entities.Invoice;
import com.restaurant.restaurantspr.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServices implements IInvoiceServices {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServices(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        if (invoiceRepository.existsById(id)) {
            updatedInvoice.setId(id);
            return invoiceRepository.save(updatedInvoice);
        }
        return null;  // or throw an exception
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> getInvoicesByCustomerId(Long customerId) {
        return invoiceRepository.findByCustomer_CustomerId(customerId);
    }

    @Override
    public List<Invoice> getInvoicesByStaffId(Long staffId) {
        return invoiceRepository.findByStaff_Id(staffId);
    }
}
