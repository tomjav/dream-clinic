package pl.tgrzybowski.dreamclinic.availability.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tgrzybowski.dreamclinic.doctor.api.DoctorDto;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProposeAppointmentDto {
    private DoctorDto doctorDto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer from;
    private Integer to;
}
