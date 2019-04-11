package at.nacs.drhousediagnoses.logic;


import at.nacs.drhousediagnoses.communication.BedClient;
import at.nacs.drhousediagnoses.communication.PharmacyClient;
import at.nacs.drhousediagnoses.logic.DrHouse;
import at.nacs.drhousediagnoses.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class Manager {

    private final DrHouse drHouse;
    private final BedClient bedClient;
    private final PharmacyClient pharmacyClient;


    public Patient post(Patient patient) {
        Patient patientByDoctor = drHouse.getDiagnoses(patient);
        String direction = drHouse.send(patientByDoctor);
        if (direction.equals("pharmacy")) {
            return pharmacyClient.postToPharmacy(patientByDoctor);
        }
        return bedClient.postToBed(patientByDoctor);
    }
}
