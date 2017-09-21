package pl.tgrzybowski.dreamclinic.availability.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkingHour {
    private Integer from;
    private Integer to;
    private HourStatus status;
}