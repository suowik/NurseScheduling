package pl.edu.pk.nurse.algorithm.constraints.hard;

import pl.edu.pk.nurse.algorithm.constraints.Constraint;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Vacancy;
import pl.edu.pk.nurse.data.util.Weekday;
import pl.edu.pk.nurse.data.util.Weight;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 12:05
 */
public class ExampleConstraint implements Constraint{

    @Override
    public Weight measure(Schedule schedule) {
        Shift shift1 = schedule.getNurse(2).getWeek(1).getShiftForDay(Weekday.THURSDAY);
        Shift shift = schedule.getWeekForNurse(2, 1).getShiftForDay(Weekday.SATURDAY);
        Vacancy vacancy = schedule.getNurse(0).getVacancy();
        throw new UnsupportedOperationException();
    }
}
