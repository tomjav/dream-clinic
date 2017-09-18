package pl.tgrzybowski.dreamclinic.employee.availability.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingHour;

import java.util.Date;
import java.util.List;

/**
 * Created by tomek on 10.09.17.
 */

@Repository
public interface AvailabilityDayRepository extends JpaRepository<AvailabilityDay, Long> {

    @Query("SELECT b FROM AvailabilityDay a LEFT JOIN a.availabilityHours b where a.availabilityDay = :date ")
    List<AvailabilityHours> getWorkingHours(@Param("date") Date date);

    @Query(value = "SELECT da.date, ho.hour_from, ho.hour_to FROM doctor doc, availability_day da, availability_hours ho \n" +
            "WHERE doc.id = da.doctor_id AND da.id = ho.id AND da.id = ?1", nativeQuery = true)
    List<WorkingHour> zz(Long doctorId);

    @Query("SELECT a FROM AvailabilityDay a WHERE a.availabilityDay = :availabilityDay")
    AvailabilityDay findByAvailabilityDayEquals(@Param("availabilityDay") Date availabilityDay);

}
