package at.nacs.drhouseaccountancy.logic;


import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

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