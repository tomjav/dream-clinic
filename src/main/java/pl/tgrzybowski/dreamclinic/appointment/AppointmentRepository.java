package pl.tgrzybowski.dreamclinic.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tgrzybowski.dreamclinic.patient.Patient;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.hourFrom > :hourFrom AND a.hourTo < :hourTo " +
            "AND a.date BETWEEN :dateFrom and :dateTo")
    List<Appointment> getAppointmentDoctor(@Param("doctorId") Long doctorId, @Param("dateFrom") Date dateFrom, @Param
            ("dateTo") Date dateTo, @Param("hourFrom") Integer hourFrom, @Param("hourTo") Integer hourTo);

    List<Appointment> findAllByPatientEqualsAndDateGreaterThan(Patient patient, Date date);

    List<Appointment> findAllByPatientEqualsAndDateLessThan(Patient patient, Date date);

    List<Appointment> findAllByPatientEquals(Patient patient);
}
