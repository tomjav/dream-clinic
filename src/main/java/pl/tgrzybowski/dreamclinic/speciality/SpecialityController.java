package pl.tgrzybowski.dreamclinic.speciality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.doctor.data.Speciality;
import pl.tgrzybowski.dreamclinic.speciality.services.SpecialityRepository;

import java.util.List;

@RestController
public class SpecialityController {

    @Autowired
    private SpecialityRepository specialityRepository;

    @GetMapping("/specialities")
    public List<Speciality> getSpecialitiesList() {
        return specialityRepository.findAll();
    }
}
