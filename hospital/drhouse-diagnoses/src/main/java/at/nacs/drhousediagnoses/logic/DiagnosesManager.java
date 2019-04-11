package at.nacs.drhousediagnoses.logic;


import at.nacs.drhousediagnoses.communication.BedClient;
import at.nacs.drhousediagnoses.communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistence.ForwordPatient;
import at.nacs.drhousediagnoses.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class DiagnosesManager {

    private final DrHouse drHouse;
    private final BedClient bedClient;
    private final PharmacyClient pharmacyClient;
    private final ForwordPatient forwordPatient;

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
        return forwordPatient.getDirections().getOrDefault(diagnosis, "Please Wait!! I can't find forwarding address");
    }

}
