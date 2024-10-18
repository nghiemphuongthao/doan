package com.restaurant.restaurantspr.Controllers;

import com.restaurant.restaurantspr.Entities.Invoice;
import com.restaurant.restaurantspr.Services.InvoiceServices.IInvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final IInvoiceServices invoiceServices;

    @Autowired
    public InvoiceController(IInvoiceServices invoiceServices) {
        this.invoiceServices = invoiceServices;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceServices.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceServices.getInvoiceById(id);
        return invoice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceServices.createInvoice(invoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice updatedInvoice) {
        Invoice invoice = invoiceServices.updateInvoice(id, updatedInvoice);
        return invoice != null ? ResponseEntity.ok(invoice) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceServices.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    public List<Invoice> getInvoicesByCustomerId(@PathVariable Long customerId) {
        return invoiceServices.getInvoicesByCustomerId(customerId);
    }

    @GetMapping("/staff/{staffId}")
    public List<Invoice> getInvoicesByStaffId(@PathVariable Long staffId) {
        return invoiceServices.getInvoicesByStaffId(staffId);
    }
}
