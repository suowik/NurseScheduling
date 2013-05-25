package pl.edu.pk.nurse.data;

import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Vacancy;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:27
 */
public class Nurse {
    private final static int CHROMOSOME_LENGTH = 40;
    private int[] chromosome;

    public Nurse(int[] chromosome) {

        if (chromosome.length != CHROMOSOME_LENGTH) {
            throw new IllegalArgumentException(String.valueOf(chromosome.length));
        }
        this.chromosome = chromosome;
    }

    public Vacancy getVacancy() {
        switch (chromosome[0]) {
            case 0:
                return Vacancy.FULL;
            case 1:
                return Vacancy.PART_32;
            case 2:
                return Vacancy.PART_20;
            default:
                throw new IllegalStateException();
        }
    }

    public List<Shift> getAllShifts() {
        List<Shift> shifts = new ArrayList<Shift>();
        for (int i = 0; i < 6; i++) {
            for (Weekday weekday : Weekday.values()) {
                shifts.add(getWeek(i).getShiftForDay(weekday));
            }
        }
        return shifts;
    }

    public Week getWeek(int value) {
        switch (value) {
            case 1:
                return convert(chromosome, 0, 8);
            case 2:
                return convert(chromosome, 9, 16);
            case 3:
                return convert(chromosome, 17, 24);
            case 4:
                return convert(chromosome, 25, 32);
            case 5:
                return convert(chromosome, 33, 40);
            default:
                throw new IllegalArgumentException();
        }
    }

    private Week convert(int[] chromosome, int start, int end) {
        return new Week(Arrays.copyOfRange(chromosome, start, end));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nurse nurse = (Nurse) o;

        return Arrays.equals(chromosome, nurse.chromosome);

    }

    @Override
    public int hashCode() {
        return chromosome != null ? Arrays.hashCode(chromosome) : 0;
    }
}
