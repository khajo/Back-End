package at.nacs.drhouseaccountancy.communication;


import at.nacs.drhouseaccountancy.logic.Accountancymanager;
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
    private final Accountancymanager accountancymanager;


    @PostMapping("/patients")
   void psot(@RequestBody PatientDTO patientDTO) {
        double cost = accountant.setCost(patientDTO);
        accountancymanager.savePatient(patientDTO);
        accountancymanager.saveInvoice(patientDTO, cost);
    }


    @GetMapping("/invoices")
    List<Invoice> getInvoices() {
        return accountancymanager.invoices();
    }

    @PutMapping("/invoices/{id}/paid")
    void put(@PathVariable Long id) {
        accountancymanager.setAspaid(id);
    }
}
