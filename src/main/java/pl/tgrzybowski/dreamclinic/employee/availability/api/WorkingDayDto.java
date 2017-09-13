package pl.tgrzybowski.dreamclinic.employee.availability.api;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class WorkingDayDto {
    Integer dayNumber;
    Integer dayOfWeek;
    boolean isDoctorAvailable;
    boolean isCurrentMonth;
}
