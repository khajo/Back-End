//package at.nacs.drhousebed;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequiredArgsConstructor
//public class DiagnosesClient {
//
//    private final RestTemplate restTemplate;
//    private final Nurse nurse;
//
//
//    @Value("${addmimssion.server.url}")
//    private String url;
//
//
//
//    @PostMapping
//    Patient post(@RequestBody Patient patientByDokter) {
//        String diagnosis = patientByDokter.getDiagnosis();
//        String treat = nurse.treat(diagnosis);
//        patientByDokter.setTreatment(treat);
//        Patient patient = restTemplate.postForObject(url, patientByDokter, Patient.class);
//        return patient;
//    }
//}
