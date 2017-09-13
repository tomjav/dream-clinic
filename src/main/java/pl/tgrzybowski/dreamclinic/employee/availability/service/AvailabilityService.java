package pl.tgrzybowski.dreamclinic.employee.availability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.employee.availability.api.HourStatus;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingDayDto;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingHour;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityDayRespository;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityHours;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityDayRespository availabilityRespository;

    @Autowired
    private DefaultAvailabilityService defaultAvailabilityService;

    public List<WorkingHour> getWorkingHoursList(Long doctorId, Date date) {
        List<AvailabilityHours> workingHours = availabilityRespository.getWorkingHours(date);

        List<WorkingHour> defaultWorkingHours = defaultAvailabilityService.getDefaultWorkingHours();

        List<WorkingHour> urgentHours =
                workingHours.stream().map(e -> new WorkingHour(e.getHourFrom(), e.getHourTo(), HourStatus.HOUR_OFF)).collect(Collectors.toList());

        List<WorkingHour> mergedHours = defaultWorkingHours.stream().filter(e -> urgentHours.stream().noneMatch(p -> e.getFrom().equals(p.getFrom()))).collect(Collectors.toList());

        mergedHours.addAll(urgentHours);
        mergedHours.sort((e, p) -> {
            if (e.getFrom().equals(p.getFrom())) return 0;
            else if (e.getFrom() > p.getFrom()) return 1;
            return -1;
        });
        return mergedHours;
    }


    public List<WorkingHour> getAvailabilityObjects(Long doctorId, Integer month) {
        List<WorkingHour> availabilityDays = availabilityRespository.zz(doctorId);
        return availabilityDays;
    }

    public List<WorkingDayDto> getDoctorAvailabilityCalendar(Long doctorId, Integer year, Integer month) {
        LocalDate calendar = LocalDate.of(year, month, 1);
        boolean leapYear = calendar.isLeapYear();
        int daysInMonthAmount = calendar.getMonth().length(leapYear);

        int firstDayOfWeekInMonthId = calendar.getDayOfWeek().getValue() - 1;
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();


        int today = LocalDate.now().getDayOfMonth();

        int dayIdCounter = 0;
        boolean firstWeek = true;
        LinkedList<WorkingDayDto> availabilityDays = new LinkedList<>();
        boolean currentMonth = true;
        for (int i = 0; i < 6; i++) {

            int offset = firstWeek ? firstDayOfWeekInMonthId : 0;

            for (int j = offset; j < 7; j++) {

                WorkingDayDto workingDayDto = new WorkingDayDto();
                workingDayDto.setDoctorAvailable(true);

                if (dayIdCounter > daysInMonthAmount) {
                    dayIdCounter = 1;
                    currentMonth = false;
                }

                int dayNumber = ++dayIdCounter % (daysInMonthAmount + 1);
                dayNumber = dayNumber == 0 ? 1 : dayNumber;

                workingDayDto.setDayNumber(dayNumber);
                workingDayDto.setCurrentMonth(currentMonth);

                int dayOfweekArrayIndex = (firstDayOfWeekInMonthId + dayIdCounter - 1) % (dayOfWeeks.length);
                workingDayDto.setDayOfWeek(dayOfweekArrayIndex);
                availabilityDays.add(workingDayDto);
            }
            firstWeek = false;
        }

        int expectedDayAmout = 6 * 7;

        int missedDayAmount = expectedDayAmout - availabilityDays.size();
        LinkedList<WorkingDayDto> missedDays = new LinkedList<>();
        for (int i = 0; i < missedDayAmount; i++) {
            WorkingDayDto day = new WorkingDayDto();
            day.setCurrentMonth(false);
            day.setDayOfWeek(i);
            day.setDoctorAvailable(false);
            missedDays.add(day);
        }

        availabilityDays.addAll(0, missedDays);

        return availabilityDays;
    }


}
