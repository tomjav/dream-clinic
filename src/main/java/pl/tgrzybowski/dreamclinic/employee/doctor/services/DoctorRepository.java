package pl.tgrzybowski.dreamclinic.employee.doctor.services;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
