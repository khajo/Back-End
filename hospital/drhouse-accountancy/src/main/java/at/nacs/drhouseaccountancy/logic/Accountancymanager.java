package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountancymanager {

    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final PatientCreator patientCreator;
    private final InvoiceCreator invoiceCreator;


    public Patient savePatient(PatientDTO patientDTO) {
        Patient patient = patientCreator.getPatient(patientDTO);
        return patientRepository.save(patient);
    }


    public Invoice saveInvoice(PatientDTO patientDTO, double cost) {
        Invoice invoice = invoiceCreator.getInvoice(patientDTO, cost);
        return invoiceRepository.save(invoice);
    }

    public void setAspaid(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isEmpty()) {
            return;
        }
        optionalInvoice.get().setPaid(true);
        invoiceRepository.save(optionalInvoice.get());

    }


    public List<Invoice> invoices() {
        return invoiceRepository.findAll();
    }
}
