package pl.tgrzybowski.dreamclinic.availability.data;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer hourFrom;

    private Integer hourTo;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

}
