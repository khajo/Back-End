package at.nacs.drhouseaccountancy.communication;


import at.nacs.drhouseaccountancy.logic.Accountancy;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountancyEndpoint {


    private final Accountancy accountancy;


    @PostMapping("/patients")
   void post(@RequestBody PatientDTO patientDTO) {
        accountancy.saveInvoice(patientDTO);
    }


    @GetMapping("/invoices")
    List<Invoice> getInvoices() {
        return accountancy.invoices();
    }

    @PutMapping("/invoices/{id}/paid")
    void put(@PathVariable Long id) {
        accountancy.setAspaid(id);
    }
}
