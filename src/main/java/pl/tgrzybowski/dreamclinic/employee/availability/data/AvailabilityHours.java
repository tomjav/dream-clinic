package pl.tgrzybowski.dreamclinic.employee.availability.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by tomek on 10.09.17.
 */

@Entity
@Data
@AllArgsConstructor
public class AvailabilityHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer hourFrom;
    private Integer hourTo;
    private Long availabilityDayId;
}
