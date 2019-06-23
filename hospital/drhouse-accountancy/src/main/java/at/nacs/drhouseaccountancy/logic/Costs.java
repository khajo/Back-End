package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Costs {

  private final Map<String, Double> prices;

  public Double calculate(PatientDTO patientDTO) {
    String provided = getProvided(patientDTO);
    return prices.get(provided);
  }

  private String getProvided(PatientDTO patientDTO) {
    if (Strings.isNotBlank(patientDTO.getTreatment())) {
      return patientDTO.getTreatment();
    }
    if (Strings.isNotBlank(patientDTO.getMedicine())) {
      return patientDTO.getMedicine();
    }
    throw new IllegalStateException("Could not calculate prices for patient dto: " + patientDTO);
  }

}
