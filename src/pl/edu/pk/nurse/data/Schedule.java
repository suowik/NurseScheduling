package pl.edu.pk.nurse.data;

import pl.edu.pk.nurse.data.util.Week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:32
 */
public class Schedule {
    private int[] chromosome;
    private int MONTH_LENGTH = 40;
    private List<Nurse> nurses;
    public Schedule(int nursesCount, int fullPart, int part32, int part20){

        this.nurses = new ArrayList<Nurse>();
        convert();
    }

    public Week getWeekForNurse(int nurseIndex, int week){
        return getNurse(nurseIndex).getWeek(week);
    }

    public Nurse getNurse(int index){
        throw new UnsupportedOperationException();
    }

    private void convert(){
        if(chromosome.length % 8 != 0){
            throw new IllegalStateException("wrong length of chromosome");
        }
        for(int start = 0; start < chromosome.length; start+= MONTH_LENGTH) {
            final int to = start + MONTH_LENGTH - 1;
            nurses.add(new Nurse(Arrays.copyOfRange(chromosome,start, to)));
        }
    }

    public List<Nurse> toEntity() {
        return nurses;
    }
}
