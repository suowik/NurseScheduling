package pl.edu.pk.nurse.algorithm;

import pl.edu.pk.nurse.constraints.Constraint;
import pl.edu.pk.nurse.constraints.hard.*;
import pl.edu.pk.nurse.constraints.soft.NightShiftsSeries030Constraint;
import pl.edu.pk.nurse.constraints.soft.NightShiftsSeries3048Constraint;
import pl.edu.pk.nurse.constraints.soft.StandAloneShiftsConstraint;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 16:37
 */
public class FitnessCalculator {

    public static final Constraint consecutiveNightShifts = new ConsecutiveNightShiftsConstraint();
    public static final Constraint consecutiveShifts = new ConsecutiveShiftsConstraint();
    public static final Constraint exceedDepartment = new ExceedDepartmentConstraint();
    public static final Constraint fullCover = new FullCoverConstraint();
    public static final Constraint hoursOfRestADay = new HoursOfRestADayConstraint();
    public static final Constraint maxNightShifts = new MaxNightShiftsConstraint();
    public static final Constraint restAfterNight = new RestAfterNightShifts();
    public static final Constraint restBeforeNightShifts = new RestBeforeNightShiftConstraint();
    public static final Constraint weekendsOfDuty = new WeekendsOfDutyConstraint();
    public static final Constraint standAloneShifts = new StandAloneShiftsConstraint();
    public static final Constraint nightShiftsSeries3048 = new NightShiftsSeries3048Constraint();
    public static final Constraint nightShiftsSeries030 = new NightShiftsSeries030Constraint();

    public static Fitness measure(Schedule schedule) {
        return measure(schedule,
                consecutiveNightShifts,
                consecutiveShifts,
                exceedDepartment,
                fullCover,
                hoursOfRestADay,
                maxNightShifts,
                restAfterNight,
                restBeforeNightShifts,
                weekendsOfDuty,
                standAloneShifts,
                nightShiftsSeries3048,
                nightShiftsSeries030);
    }

    private static Fitness measure(Schedule schedule, Constraint... constraints) {
        int result = 0;
        for (Constraint constraint : constraints) {
            result += constraint.measure(schedule).getValue();
        }
        return new Fitness(result);
    }

}
