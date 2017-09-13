package pl.tgrzybowski.dreamclinic.employee.availability.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HourStatus {

    FREE(1), APPOINTMENT(2), HOUR_OFF(3);

    Integer id;
}
