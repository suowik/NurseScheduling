package pl.edu.pk.nurse.data.util;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:53
 */
public class Week {
    private int[] chromosome;
    public Week(int[] chromosome){
        if(chromosome.length != 8){
            throw new IllegalArgumentException();
        }
        this.chromosome = chromosome;
    }

    public Shift getShiftForDay(Weekday weekday){
        return Shift.convert(chromosome[weekday.index()]);
    }
}
