package pl.tgrzybowski.dreamclinic.employee.doctor.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.patient.Patient;

import java.util.List;

public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE d.speciality.id = :specialityId")
    List<Doctor> findAllBySpeciality(@Param(value = "specialityId") Long specialityId);

    @Query(value = "SELECT p FROM Doctor p where p.account.id = :accountId")
    Doctor findOneByAccountId(@Param("accountId") Long accountId);
}
