package pl.tgrzybowski.dreamclinic.employee.availability.api;

import lombok.Data;

import java.util.Date;

@Data
public class DayOffDto {
    Integer hourFrom;
    Integer hourTo;
    private Date date;
}
