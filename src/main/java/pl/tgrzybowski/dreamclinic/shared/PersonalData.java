package pl.tgrzybowski.dreamclinic.shared;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
public class PersonalData {
    private String name;
    private String surname;
    private Date birthDay;
    private Gender sex;
}