package at.nacs.administrationui.communication.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Invoice {

  private Long id;
  private PatientDTO patient;
  private String kind;
  private String symptoms;
  private String diagnosis;
  private String provided;
  private double cost;
  private boolean paid;
  private LocalDateTime timestamp;

}
