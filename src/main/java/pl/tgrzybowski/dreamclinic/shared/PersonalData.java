package pl.tgrzybowski.dreamclinic.shared;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class PersonalData {
    private String name;
    private String surname;
    private Date birthDay;
    private Gender sex;
}