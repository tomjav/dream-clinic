package pl.tgrzybowski.dreamclinic.employee.availability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingDayDto;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityDay;
import pl.tgrzybowski.dreamclinic.employee.availability.service.AvailabilityService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;


    @GetMapping("/doctor/{doctorId}/availability/workingdays")
    public List<WorkingDayDto> getWorkingDays(@PathVariable Long doctorId,
                                              @RequestParam(value = "year", required = false) Integer year,
                                              @RequestParam("month") Integer month) {

        year = year == null ? LocalDate.now().getYear() : year;
        return availabilityService.getDoctorAvailabilityCalendar(doctorId, year, month);
    }

    @GetMapping("/aaa")
    public List<AvailabilityDay> getWorkingDays() {

        return availabilityService.getAvailabilityObjects(1L, 10);
    }
}
