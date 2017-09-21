package pl.tgrzybowski.dreamclinic.availability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tgrzybowski.dreamclinic.availability.api.*;
import pl.tgrzybowski.dreamclinic.availability.data.Availability;
import pl.tgrzybowski.dreamclinic.availability.service.AvailabilityService;
import pl.tgrzybowski.dreamclinic.doctor.services.DoctorRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class AvailabilityController {


    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private DoctorRepository doctorRepository;




    @RequestMapping(value = "/doctor/{doctorId}/availability/hours", method = RequestMethod.POST)
    public void getDayOff(@PathVariable Long doctorId, @RequestBody DayOffDto dto) {
//        availabilityService.getDayOff(doctorId, dto.getDate(), dto.getHourFrom(), dto.getHourTo());
    }

    @RequestMapping(value = "/doctor/{doctorId}/availability/hours", method = RequestMethod.GET)
    public List<WorkingHour> getWorkingDays(@PathVariable Long doctorId, @RequestParam String date) throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date zp = s.parse(date);
        return availabilityService.getWorkingHoursList(doctorId, zp);
    }
    @RequestMapping(value = "/doctor/{doctorId}/availability/workingdays", method = RequestMethod.GET)
    public List<WorkingDayDto> getWorkingDays(@PathVariable Long doctorId,
                                              @RequestParam(value = "year", required = false) Integer year,
                                              @RequestParam("month") Integer month) {

        year = year == null ? LocalDate.now().getYear() : year;
        return availabilityService.getDoctorAvailabilityCalendar(doctorId, year, month);
    }

    @GetMapping(value = "/speciality/availability")
    public List<ProposeAppointmentDto> getProposeAppointmentDto(@RequestParam Long specialityId,
                                                                @ModelAttribute FilterDto filter) {

        return availabilityService.getAvailabilityDoctorInTime(specialityId, filter);
    }
}
