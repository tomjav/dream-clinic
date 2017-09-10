package pl.tgrzybowski.dreamclinic.employee.availability.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tomek on 10.09.17.
 */

@Repository
public interface AvailabilityRespository extends JpaRepository<AvailabilityDay, Long> {

    public List<AvailabilityDay> findAvailabilityDaysByDoctorId(Long doctorId, Integer month);
}
