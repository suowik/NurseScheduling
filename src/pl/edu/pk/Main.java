package pl.edu.pk;

import pl.edu.pk.nurse.algorithm.Crossover;
import pl.edu.pk.nurse.algorithm.Mutate;
import pl.edu.pk.nurse.data.Schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int POPULATION_SIZE = 1500;
    private static final Crossover crossover = new Crossover();
    private static final Mutate mutate = new Mutate();
    private static final int OPTIMAL_SOLUTION = 666;

    public static void main(String[] args) {
        List<Schedule> initialPopulation = new ArrayList<Schedule>();
        for(int i  = 0; i < POPULATION_SIZE; i++){
            initialPopulation.add(new Schedule(16,12,3,1));
        }
        Schedule schedule = execute(initialPopulation);
        System.out.println(schedule);
    }

    private static Schedule execute(List<Schedule> population) {
        //1. sprawdzic dopasowanie
        //2. posortowac po dopasowaniu
        //3. przyjac 25% najlepszych
        //4. krzyzowanie
        //5. mutowanie
        //6. powrot do 1 jesli niezadowalajace
        for (Schedule schedule : population) {
            schedule.fitness();
        }
        Collections.sort(population);
        if(Collections.max(population).fitness().getValue() > OPTIMAL_SOLUTION){
            return Collections.max(population);
        }
        List<Schedule> newPopulation = population.subList(0,population.size()/4);
        List<Schedule> result = new ArrayList<Schedule>();
        for(int i = 0; i < newPopulation.size()-1;i++){
            Schedule offspring = crossover.apply(newPopulation.get(i), newPopulation.get(i + 1));
            offspring = mutate.apply(offspring);
            result.add(offspring);
            result.addAll(newPopulation);
        }
        return execute(result);
    }
}
