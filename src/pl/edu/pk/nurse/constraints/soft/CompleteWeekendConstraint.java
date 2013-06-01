package pl.edu.pk.nurse.constraints.soft;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 01.06.13
 * Time: 19:04
 */
public class CompleteWeekendConstraint extends SoftConstraint {

    @Override
    public Fitness measure(Schedule schedule) {
        int penalty = 0;
        for (Nurse nurse : schedule.toEntity()) {
            for (int i = 0; i < 5; i++) {
                if (!isCompleteWeekend(nurse.getWeek(i))) {
                    penalty++;
                }
            }
        }
        return new Fitness(penalty * 1000);
    }

    public boolean isCompleteWeekend(Week week) {
        int shiftsCount = 0;
        Shift saturday = week.getShiftForDay(Weekday.SATURDAY);
        Shift sunday = week.getShiftForDay(Weekday.SUNDAY);
        Shift monday = week.getShiftForDay(Weekday.MONDAY);
        shiftsCount += isShift(saturday);
        shiftsCount += isShift(sunday);
        shiftsCount += isShift(monday);
        return shiftsCount == 0 || shiftsCount > 1;
    }

    public int isShift(Shift shift) {
        return shift.equals(Shift.NO_SHIFT) ? 0 : 1;
    }
}
