package at.nacs.drhousediagnoses;


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


    public Patient post(Patient person) {
        Patient patient = drHouse.getDiagnoses(person);
        String direction = drHouse.send(patient);
        if (direction.equals("pharmacy")) {
            return pharmacyClient.postToPharmacy(patient);
        }
        return bedClient.postToBed(patient);
    }
}
