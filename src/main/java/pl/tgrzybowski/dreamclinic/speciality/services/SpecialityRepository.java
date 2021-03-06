package pl.tgrzybowski.dreamclinic.speciality.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.doctor.data.Speciality;

@RestController
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    Speciality findByNameEquals(String name);
}
