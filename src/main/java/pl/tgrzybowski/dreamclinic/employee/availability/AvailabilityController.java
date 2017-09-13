package pl.tgrzybowski.dreamclinic.employee.availability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingDayDto;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingHour;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityHours;
import pl.tgrzybowski.dreamclinic.employee.availability.service.AvailabilityService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;


    @RequestMapping(value = "/doctor/{doctorId}/availability/workingdays", method = RequestMethod.GET)
    public List<WorkingDayDto> getWorkingDays(@PathVariable Long doctorId,
                                              @RequestParam(value = "year", required = false) Integer year,
                                              @RequestParam("month") Integer month) {

        year = year == null ? LocalDate.now().getYear() : year;
        return availabilityService.getDoctorAvailabilityCalendar(doctorId, year, month);
    }

    @RequestMapping(value = "/doctor/{doctorId}/availability/hours", method = RequestMethod.GET)
    public List<WorkingHour> getWorkingDays(@PathVariable Long doctorId, @RequestParam String date) throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date zp = s.parse(date);
        return availabilityService.getWorkingHoursList(doctorId, zp);
    }
}
