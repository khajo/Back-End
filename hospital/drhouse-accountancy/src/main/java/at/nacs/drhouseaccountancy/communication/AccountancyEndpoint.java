package at.nacs.drhouseaccountancy.communication;


import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountancyEndpoint {

    private final Accountant accountant;


    @PostMapping("/patients")
    PatientDTO psot(@RequestBody PatientDTO patientDTO) {
        return accountant.store(patientDTO);
    }



    @GetMapping("/invoices")
    List<Invoice> getInvoices() {
        return accountant.invoices();
    }

    @PutMapping("/invoices/{id}/paid")
    void put(@PathVariable Long id) {
        accountant.setAspaid(id);
    }
}
