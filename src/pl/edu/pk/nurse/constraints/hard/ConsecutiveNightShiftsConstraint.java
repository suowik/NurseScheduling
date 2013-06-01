package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.Configuration;
import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

/**
 * User: msendyka
 * Date: 21.05.13
 * Time: 21:12
 * •	The number of consecutive night shifts is at most 3.
 */
public class ConsecutiveNightShiftsConstraint extends HardConstraint {
    public static final int MAX_CONSECUTIVE_SHIFTS = 3;

    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;
        for (Nurse nurse : schedule.toEntity()) {
            int consecutiveShifts = 0;
            for (int i = 0; i < 5; i++) {
                Week week = nurse.getWeek(i);
                for (Weekday weekday : Weekday.values()) {
                    if (week.getShiftForDay(weekday) == Shift.NIGHT) {
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
        return new Fitness(violated * Configuration.HARD_CONSTRAINT_WEIGHT);
    }
}
