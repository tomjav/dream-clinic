package pl.tgrzybowski.dreamclinic.availability.api;

import lombok.Data;

@Data
public class FilterDto {
    private String dateFrom;
    private String dateTo;
    private Integer from;
    private Integer to;
}
