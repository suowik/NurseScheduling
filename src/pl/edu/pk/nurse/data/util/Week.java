package pl.edu.pk.nurse.data.util;

import java.util.Arrays;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:53
 */
public class Week {
    private final int CHROMOSOME_LENGTH;
    private int[] chromosome;

    public Week(int[] chromosome){
        CHROMOSOME_LENGTH = 8;
        if(chromosome.length != CHROMOSOME_LENGTH){
            throw new IllegalArgumentException(String.valueOf(chromosome.length));
        }
        this.chromosome = chromosome;
    }

    public Shift getShiftForDay(Weekday weekday){
        return Shift.convert(chromosome[weekday.index()]);
    }

    @Override
    public String toString() {
        return "Week{" +
                "CHROMOSOME_LENGTH=" + CHROMOSOME_LENGTH +
                ", chromosome=" + Arrays.toString(chromosome) +
                '}';
    }
}
