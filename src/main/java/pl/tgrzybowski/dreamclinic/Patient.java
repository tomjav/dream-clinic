package pl.tgrzybowski.dreamclinic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Patient {
    @Id
    private Long id;
    private String name;
}
