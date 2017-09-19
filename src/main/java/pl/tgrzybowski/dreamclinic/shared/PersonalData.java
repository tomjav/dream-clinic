package pl.tgrzybowski.dreamclinic.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalData implements Serializable {
    private String name;
    private String surname;
    private Date birthDay;
    private Gender sex;
}