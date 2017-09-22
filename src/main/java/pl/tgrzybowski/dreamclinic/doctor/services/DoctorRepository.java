package pl.tgrzybowski.dreamclinic.doctor.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE d.speciality.id = :specialityId")
    List<Doctor> findAllBySpeciality(@Param(value = "specialityId") Long specialityId);

    @Query(value = "SELECT p FROM Doctor p where p.account.id = :accountId")
    Doctor findOneByAccountId(@Param("accountId") Long accountId);
}
