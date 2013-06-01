package pl.edu.pk.nurse.constraints.soft;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 01.06.13
 * Time: 19:24
 */
public class NightAfterEarlyShiftsConstraint extends SoftConstraint {

    @Override
    public Fitness measure(Schedule schedule) {
        int penalty = 0;
        for(Nurse nurse : schedule.toEntity()) {
            List<Shift> nurseShifts = nurse.getAllShifts();
            for(int i=0;i<nurseShifts.size()-1;i++) {
                if(nurseShifts.get(i).equals(Shift.EARLY) && nurseShifts.get(i+1).equals(Shift.NIGHT)) {
                    penalty++;
                }
            }
        }
        return new Fitness(penalty);
    }
}
