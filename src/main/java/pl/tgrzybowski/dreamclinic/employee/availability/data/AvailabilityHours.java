package pl.tgrzybowski.dreamclinic.employee.availability.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by tomek on 10.09.17.
 */

@Entity
@Data
public class AvailabilityHours {
    @Id
    private Long id;
    private Integer hourFrom;
    private Integer hourTo;
    private Long availabilityDayId;
}
