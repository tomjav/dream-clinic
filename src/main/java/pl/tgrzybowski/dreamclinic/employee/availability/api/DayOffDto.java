package pl.tgrzybowski.dreamclinic.employee.availability.api;

import lombok.Data;

import java.util.Date;

@Data
public class DayOffDto {
    private Integer hourId;
    private Date date;
}
