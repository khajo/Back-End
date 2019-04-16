package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@RequiredArgsConstructor
@Service
public class CostManager {

    private final Map<String, Double> prices;


    public double getCost(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return getTreatmentCost(patientDTO);

        }
        return getMedicineCost(patientDTO);
    }

    private double getMedicineCost(PatientDTO patientDTO) {
        String medicine = patientDTO.getMedicine();
        if (prices.containsKey(medicine)) {
            return prices.get(medicine);
        }
        throw new IllegalArgumentException("Cost not found for medicine: " + medicine);
    }

    private double getTreatmentCost(PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
        return prices.getOrDefault(treatment, null);

    }
}
