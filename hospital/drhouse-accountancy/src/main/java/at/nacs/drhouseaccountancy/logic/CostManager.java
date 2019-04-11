package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@RequiredArgsConstructor
@Service
public class CostManager {

    private final Map<String, Double> prices;


    public double setCost(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return getTreatmentCost(patientDTO);

        }
        return getMedicineCost(patientDTO);
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
