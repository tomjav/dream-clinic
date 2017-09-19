package pl.tgrzybowski.dreamclinic.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT p FROM Patient p where p.account.id = :accountId")
    Patient findOneByAccountId(@Param("accountId") Long accountId);
}
