package pl.tgrzybowski.dreamclinic.employee.availability.api;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class WorkingDayDto {
    Integer dayNumber;
    DayOfWeek dayOfWeek;
    boolean isDoctorAvailable;
    boolean isCurrentMonth;
}
