package pl.edu.pk.nurse.data;

import pl.edu.pk.nurse.data.util.Week;

import java.util.List;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:32
 */
public class Schedule {
    private int[] chromosome;

    public Schedule(int nurses, int fullPart, int part32, int part20){

    }

    public Week getWeekForNurse(int nurseIndex, int week){
        return getNurse(nurseIndex).getWeek(week);
    }

    public Nurse getNurse(int index){
        throw new UnsupportedOperationException();
    }

    public List<Nurse> toEntity(){
        throw new UnsupportedOperationException();
    }

}
