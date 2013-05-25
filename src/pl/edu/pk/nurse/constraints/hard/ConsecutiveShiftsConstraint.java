package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

/**
 * User: msendyka
 * Date: 21.05.13
 * Time: 20:51
 * •	The number of consecutive shifts (workdays) is at most 6.
 */
public class ConsecutiveShiftsConstraint extends HardConstraint {

    private static final int E = 3;
    private static final int D = 3;
    private static final int L = 3;
    private static final int N = 1;
    public static final int MAX_CONSECUTIVE_SHIFTS = 6;

    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;
        for (Nurse nurse : schedule.toEntity()) {
            int consecutiveShifts = 0;
            for (int i = 0; i < 6; i++) {
                Week week = nurse.getWeek(i);
                for (Weekday weekday : Weekday.values()) {
                    if (week.getShiftForDay(weekday) == Shift.NO_SHIFT) {
                        consecutiveShifts++;
                        if (consecutiveShifts > MAX_CONSECUTIVE_SHIFTS) {
                            violated++;
                        }
                    } else {
                        consecutiveShifts = 0;
                    }
                }
            }
        }

        return new Fitness(violated);
    }
}
