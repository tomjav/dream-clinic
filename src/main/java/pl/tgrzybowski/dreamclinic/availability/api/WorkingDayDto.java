package pl.tgrzybowski.dreamclinic.availability.api;

import lombok.Data;

@Data
public class WorkingDayDto {
    Integer dayNumber;
    Integer dayOfWeek;
    boolean isDoctorAvailable;
    boolean isCurrentMonth;
}
