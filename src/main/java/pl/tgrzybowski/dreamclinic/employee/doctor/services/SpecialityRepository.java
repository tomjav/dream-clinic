package pl.tgrzybowski.dreamclinic.employee.doctor.services;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
