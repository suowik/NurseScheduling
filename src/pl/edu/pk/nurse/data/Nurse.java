package pl.edu.pk.nurse.data;

import pl.edu.pk.nurse.data.util.Vacancy;
import pl.edu.pk.nurse.data.util.Week;

import java.util.Arrays;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:27
 */
public class Nurse {
    private int[] chromosome;

    public Nurse(int[] chromosome) {
        if(chromosome.length != 8*5){
            throw new IllegalArgumentException();
        }
        this.chromosome = chromosome;
    }

    public Vacancy getVacancy(){
        switch (chromosome[0]){
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

    public Week getWeek(int value){
        switch (value){
            case 1:
                return convert(chromosome,0,7);
            case 2:
                return convert(chromosome,8,15);
            case 3:
                return convert(chromosome,16,23);
            case 4:
                return convert(chromosome,24,31);
            case 5:
                return convert(chromosome,32,39);
            default:
                throw new IllegalArgumentException();
        }
    }

    private Week convert(int[] chromosome, int start, int end) {
        return new Week(Arrays.copyOfRange(chromosome, start, end));
    }


}