import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Damian Raczkowski
 * @author Jan Malek
 * klasa Simulation odpowiada za stworzenie Studenta, wygenerowanie planu zajęć oraz przeprowadzenie całej symulacji semestru.
 *
 */
public class Simulation
{
    public static final String[] dayNames = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Weekend"};
    public static List<Subject> allSubjects = new LinkedList<Subject>();

    public static void main(String[] args)
    {
        generateSubjects(allSubjects);
        //Stworzenie studenta
        IStudentStatGenerator generator = new StudentStatGenerator();
        Student janusz= new Student(generator);
        System.out.println("Statystyki studenta: ");
        System.out.println(janusz.printStats());
        //Stworzenie jego planu zajęć
        List<Subject> plan = new ArrayList<>();
        Random rand = new Random();
        generatePlan(plan, rand, allSubjects);
        //Wydruk planu
        System.out.println("Jego plan to: ");
        for (int i = 0; i < 5; i++)
            System.out.println(dayNames[i] + ": " + plan.get(i));

        simulationLoop(15, janusz, plan);
    }
    static void generateSubjects(List<Subject> list)
    {
        //Dodanie przedmiotów do listy z której będą losowane
        list.add(new Subject("Matematyka"));
        list.add(new Subject("Filozofia"));
        list.add(new Subject("Programowanie"));
        list.add(new Subject("Miernictwo"));
        list.add(new Subject("Fizyka"));
    }
    static void generatePlan(List<Subject> plan, Random rand, List<Subject> subjectList)
    {
        for (int i = 0; i < 5; i++)
        {
            int range = subjectList.size() - 1;
            if(range > 1)
            {
                int subjectIndex = rand.nextInt(range);
                plan.add(subjectList.get(subjectIndex));
                subjectList.remove(subjectIndex);
            }
            else
            {
                plan.add(subjectList.get(0));
                subjectList.remove(0);
            }
        }
    }

    static void simulationLoop(int weeks, Student student, List<Subject> plan)
    {
        for (int week = 1; week <= weeks; week++)
        {
            for(int day = 0; day < 6; day++)
            {
                System.out.println("Dziś jest " + dayNames[day] + " tydzień " + week);
                if(day == 5)
                {
                    System.out.println("Weekend! Brak zajęć");
                }
                else
                {
                    System.out.println("Dzisiejsze zajęcia to: " + plan.get(day));
                }
                student.removeExpiredStatisticChanges();
            }
        }
    }
}



