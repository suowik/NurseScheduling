package pl.edu.pk;

import pl.edu.pk.nurse.algorithm.Crossover;
import pl.edu.pk.nurse.algorithm.Mutate;
import pl.edu.pk.nurse.data.Schedule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int POPULATION_SIZE = 1000;

    public static void main(String[] args) {
        List<Schedule> initialPopulation = new ArrayList<Schedule>();
        for(int i  = 0; i < POPULATION_SIZE; i++){
            initialPopulation.add(new Schedule(16,12,3,1));
        }
        Schedule schedule1 = initialPopulation.get(0);
        Schedule schedule2 = initialPopulation.get(1);
        Schedule crossedOver = new Crossover().apply(schedule1,schedule2);
        Schedule mutated = new Mutate().apply(crossedOver);
        //generowac 1500 schedule
        //1. sprawdzic dopasowanie
        //2. posortowac po dopasowaniu
        //3. przyjac 25% najlepszych
        //4. krzyzowanie
        //5. mutowanie
        //6. powrot do 1 jesli niezadowalajace
    }
}
