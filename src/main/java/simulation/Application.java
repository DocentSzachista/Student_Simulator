package simulation;

import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.plan.RandomPlanGenerator;
import simulation.student.Student;
import simulation.subject.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * simulation.student.Student simulation.Simulation
 * <p>Program mający za zadanie utworzyć studenta i poddać go próbie przetrwania pierwszego semestru
 * na uczelni. Semestr składa się z 10 tygodni</p>
 *
 * @author Damian Raczkowski
 * @author Jan Malek
 * @version 1.0
 * @since 23-05-2020
 * klasa simulation.Simulation odpowiada za stworzenie Studenta, wygenerowanie planu zajęć, wylosowanie wydarzenia
 * po zajęciach oraz przeprowadzenie całej symulacji semestru.
 */
public class Application
{
    public static void main(String[] args)
    {
        List<Subject> availableSubjects = new ArrayList<>();

        availableSubjects.add(new Subject("Matematyka", emptyList()));
        availableSubjects.add(new Subject("Filozofia", emptyList()));
        availableSubjects.add(new Subject("Programowanie", emptyList()));
        availableSubjects.add(new Subject("Miernictwo", emptyList()));
        availableSubjects.add(new Subject("Fizyka", emptyList()));

        RandomPlanGenerator randomPlanGenerator = new RandomPlanGenerator(availableSubjects);
        Simulation simulation = new Simulation(emptyList(), new Student(null, randomPlanGenerator.generate()));

        List<Day> daysToSimulate = Arrays.asList(
                Day.FRIDAY, Day.SUNDAY, Day.WEDNESDAY
        );
        //simulation.run(daysToSimulate.iterator());
    }
}



