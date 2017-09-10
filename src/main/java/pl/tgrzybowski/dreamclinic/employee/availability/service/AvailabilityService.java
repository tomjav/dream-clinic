package pl.tgrzybowski.dreamclinic.employee.availability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingDayDto;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityDay;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityRespository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRespository availabilityRespository;

    public List<AvailabilityDay> getAvailabilityObjects(Long doctorId, Integer month){
        List<AvailabilityDay> availabilityDays = availabilityRespository.findAvailabilityDaysByDoctorId(doctorId, month);
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
                workingDayDto.setDayOfWeek(dayOfWeeks[dayOfweekArrayIndex]);
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
            day.setDayOfWeek(dayOfWeeks[i]);
            day.setDoctorAvailable(false);
            missedDays.add(day);
        }

        availabilityDays.addAll(0, missedDays);

        return availabilityDays;
    }


}
