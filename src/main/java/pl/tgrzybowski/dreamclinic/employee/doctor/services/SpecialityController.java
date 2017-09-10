package pl.tgrzybowski.dreamclinic.employee.doctor.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Speciality;

import java.util.List;

@RestController
public class SpecialityController {

    private SpecialityRepository specialityRepository;

    @GetMapping("/specialities")
    public List<Speciality> getSpecialities(){
        return specialityRepository.findAll();
    }
}
