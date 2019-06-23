package at.nacs.drhouseaccountancy.communication.endpoint;

import at.nacs.drhouseaccountancy.logic.Invoices;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/invoices")
public class InvoicesEndpoint {

    private final Invoices invoices;

    List<Invoice> getInvoices() {
        return invoices.findAll();
    }

    @PutMapping("{id}/paid")
    void paid(@PathVariable Long id) {
        invoices.markAsPaid(id);
    }
}
