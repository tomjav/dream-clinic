package pl.tgrzybowski.dreamclinic.availability.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;

import java.util.Date;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findAllByDoctorAndDateBetweenAndHourFromGreaterThanEqualAndHourToLessThanEqual
            (Doctor doctor, Date dateFrom, Date dateTo, Integer hourFrom, Integer hourTo);

    List<Availability> findAllByDoctorEqualsAndDateEquals(Doctor doctor, Date date);
}
