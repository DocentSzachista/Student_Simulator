package simulation;

import simulation.event.EventsDatabase;
import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.plan.RandomPlanGenerator;
import simulation.student.Student;
import simulation.student.StudentStatGenerator;
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

        EventsDatabase database = new EventsDatabase();

        availableSubjects.add(new Subject("Matematyka", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Filozofia", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Programowanie", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Miernictwo", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Fizyka", database.getSchoolEvents()));

        RandomPlanGenerator randomPlanGenerator = new RandomPlanGenerator(availableSubjects);
        StudentStatGenerator statGenerator = new StudentStatGenerator();
        Simulation simulation = new Simulation(database.getWeekendEvents(), new Student(statGenerator.generate(), randomPlanGenerator.generate()));

        simulation.run(10);
    }
}



