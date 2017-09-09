package pl.tgrzybowski.dreamclinic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    private List<Patient> getPatientList() {
        log.debug("Przyjecie rzadania");
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("Tomek");
        patientRepository.save(patient);
        log.debug("Utworzenie rekordku");
        List<Patient> all = patientRepository.findAll();
        log.debug("Pobranie rekordu");
        return all;

    }
}
