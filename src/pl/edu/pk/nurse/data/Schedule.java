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

    public Schedule(int[] chromosome){
        this.chromosome = chromosome;
        convertToEntity();
    }

    public Schedule(int nursesCount, int fullPart, int part32, int part20){
        chromosome = new int[nursesCount * MONTH_LENGTH];
        generateChromosome(nursesCount, fullPart, part32, part20);
        convertToEntity();
    }

    private void generateChromosome(int nursesCount, int fullPart, int part32, int part20) {

    }

    public Week getWeekForNurse(int nurseIndex, int week){
        return getNurse(nurseIndex).getWeek(week);
    }

    public Nurse getNurse(int index){
        return nurses.get(index);
    }

    private void convertToEntity(){
        if(chromosome.length % 8 != 0){
            throw new IllegalStateException("wrong length of chromosome");
        }
        this.nurses = new ArrayList<Nurse>();
        for(int start = 0; start < chromosome.length; start+= MONTH_LENGTH) {
            final int to = start + MONTH_LENGTH - 1;
            nurses.add(new Nurse(Arrays.copyOfRange(chromosome,start, to)));
        }
    }

    public List<Nurse> toEntity() {
        convertToEntity();
        return nurses;
    }

    public int[] getChromosome() {
        return chromosome;
    }
}
