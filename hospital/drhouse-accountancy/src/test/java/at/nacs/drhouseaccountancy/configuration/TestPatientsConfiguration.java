package at.nacs.drhouseaccountancy.configuration;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("test-patients")
@Getter
@Setter
public class TestPatientsConfiguration {

  private PatientDTO patientDtoTreatment;
  private PatientDTO patientDtoMedicine;
  private Patient patient;

  @Bean
  PatientDTO patientDtoTreatment() {
    return patientDtoTreatment;
  }

  @Bean
  PatientDTO patientDtoMedicine() {
    return patientDtoMedicine;
  }

  @Bean
  Patient patient() {
    return patient;
  }

}
