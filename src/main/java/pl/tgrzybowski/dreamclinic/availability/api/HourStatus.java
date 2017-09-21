package pl.tgrzybowski.dreamclinic.availability.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HourStatus {

    FREE_TIME(1), APPOINTMENT(2), HOUR_OFF(3);

    Integer id;
}
