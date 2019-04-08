package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Accountant {

    private final Map<String, Double > prices;


    public PatientDTO addCost(PatientDTO patientDTO) {

        Invoice invoice = new Invoice();
     invoice.setProvided(patientDTO.);

    }

    private Double getMedicineCost(PatientDTO patientDTO) {
        String medicine = patientDTO.getMedicine();
        return prices.getOrDefault(medicine, null);

    }
    private Double getTreatmentCost(PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
      return prices.getOrDefault(treatment, null);

    }


}
