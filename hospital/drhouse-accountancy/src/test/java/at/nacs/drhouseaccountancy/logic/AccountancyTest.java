package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = NONE)
class AccountancyTest {


    @Autowired
    InvoiceRepository invoiceRepository;


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    Accountancy accountancy;


    @Setter
    PatientDTO patientDTO;

    @Setter
    PatientDTO patientDTOSpecial;



    @BeforeEach
    void before() {
        patientRepository.deleteAll();
        invoiceRepository.deleteAll();
    }


    @Test

    void savePatient() {
    }

    @Test
    void saveInvoice() {
    }

    @Test
    void setAspaid() {
    }

    @Test
    void invoices() {
    }
}