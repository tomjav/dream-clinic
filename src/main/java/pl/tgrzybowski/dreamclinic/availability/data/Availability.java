package pl.tgrzybowski.dreamclinic.availability.data;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Availability {

    @Id
    private Long id;

    private Integer hourFrom;

    private Integer hourTo;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

}
