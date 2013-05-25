package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

/**
 * User: msendyka
 * Date: 24.05.13
 * Time: 22:25
 * •	The maximum number of night shifts is 3 per period of 5 consecutive weeks.
 */
public class MaxNightShiftsConstraint extends HardConstraint {
    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;

        for (Nurse nurse : schedule.toEntity()) {
            int nightShiftsCount = 0;
            for (int i = 0; i < 5; i++) {
                Week week = nurse.getWeek(i);
                for (Weekday weekday : Weekday.values()) {
                    if (week.getShiftForDay(weekday) == Shift.NIGHT) {
                        nightShiftsCount++;
                    }
                }
            }
            if (nightShiftsCount > 3) {
                violated++;
            }
        }
        return new Fitness(violated);
    }
}
