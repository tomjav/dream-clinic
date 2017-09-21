package pl.tgrzybowski.dreamclinic.availability.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayOffDto {
    Integer hourFrom;
    Integer hourTo;
    private Date date;
}
