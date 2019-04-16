package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountancy {

    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final PatientCreator patientCreator;
    private final InvoiceCreator invoiceCreator;


    public Invoice invoice(PatientDTO patientDTO) {
        Patient patient = savePatient(patientDTO);
        Invoice invoice = invoiceCreator.create(patientDTO, patient);
        return invoiceRepository.save(invoice);
    }

    private Patient savePatient(PatientDTO patientDTO) {
        // check first if the patient is there findingin by uuid
        Patient patient = patientCreator.creat(patientDTO);
        return patientRepository.save(patient);
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
