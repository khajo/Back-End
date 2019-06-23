package at.nacs.drhouseaccountancy.configuration;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("test-invoices")
@Getter
@Setter
public class TestInvoicesConfiguration {

  private Invoice invoiceTreatment;
  private Invoice invoiceMedicine;

  @Bean
  Invoice invoiceTreatment() {
    return invoiceTreatment;
  }

  @Bean
  Invoice invoiceMedicine() {
    return invoiceMedicine;
  }

}
