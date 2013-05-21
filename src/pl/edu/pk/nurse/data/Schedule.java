package pl.edu.pk.nurse.data;

import pl.edu.pk.nurse.data.util.Vacancy;
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

    public Schedule(int[] chromosome) {
        this.chromosome = chromosome;
        convertToEntity();
    }

    public Schedule(int nursesCount, int fullPart, int part32, int part20) {
        chromosome = new int[nursesCount * MONTH_LENGTH];
        generateChromosome(fullPart, part32, part20);
        convertToEntity();
    }

    private void generateChromosome(int fullPart, int part32, int part20) {
        generate(0, fullPart * MONTH_LENGTH, Vacancy.FULL);
        generate(fullPart * MONTH_LENGTH, (fullPart + part32) * MONTH_LENGTH, Vacancy.PART_32);
        generate((fullPart + part32) * MONTH_LENGTH, (fullPart + part32 + part20) * MONTH_LENGTH, Vacancy.PART_20);
    }

    private void generate(int start, int end, Vacancy vacancy) {
        for (int i = start; i < end; i++) {
            if (i % 8 == 0) {
                chromosome[i] = vacancy.getValue();
            } else {
                chromosome[i] = (int) (Math.random() * 5);
            }
        }
    }

    public Week getWeekForNurse(int nurseIndex, int week) {
        return getNurse(nurseIndex).getWeek(week);
    }

    public Nurse getNurse(int index) {
        return nurses.get(index);
    }

    private void convertToEntity() {
        if (chromosome.length % 8 != 0) {
            throw new IllegalStateException("wrong length of chromosome");
        }
        this.nurses = new ArrayList<Nurse>();
        for (int start = 0; start < chromosome.length; start += MONTH_LENGTH) {
            final int to = start + MONTH_LENGTH;
            nurses.add(new Nurse(Arrays.copyOfRange(chromosome, start, to)));
        }
    }

    public List<Nurse> toEntity() {
        convertToEntity();
        return nurses;
    }

    public int[] getChromosome() {
        return chromosome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (!Arrays.equals(chromosome, schedule.chromosome)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return chromosome != null ? Arrays.hashCode(chromosome) : 0;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "chromosome=" + Arrays.toString(chromosome) +
                '}';
    }
}
