package at.nacs.drhousediagnoses.logic;


import at.nacs.drhousediagnoses.communication.client.BedClient;
import at.nacs.drhousediagnoses.communication.client.PharmacyClient;
import at.nacs.drhousediagnoses.Configuration.DestinationConfiguration;
import at.nacs.drhousediagnoses.communication.dto.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DiagnosesManager {

    private final DrHouse drHouse;
    private final BedClient bedClient;
    private final PharmacyClient pharmacyClient;
    private final DestinationConfiguration destinationConfiguration;

    public Patient post(Patient patient) {
        Patient patientByDoctor = drHouse.setDiagnoses(patient);
        String direction = send(patientByDoctor);
        if (direction.equals("pharmacy")) {
            return pharmacyClient.postToPharmacy(patientByDoctor);
        }
        return bedClient.postToBed(patientByDoctor);
    }

        public String send(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        return destinationConfiguration.getDirections().getOrDefault(diagnosis, "Please Wait!! I can't find forwarding address");
    }

}
