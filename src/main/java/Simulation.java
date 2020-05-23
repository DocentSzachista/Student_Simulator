import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Damian Raczkowski
 * @author Jan Malek
 * klasa Simulation odpowiada za stworzenie Studenta, wygenerowanie planu zajęć oraz przeprowadzenie całej symulacji semestru.
 *
 */
public class Simulation
{
    public static final String[] dayNames = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Weekend"};
    public static LinkedList<Subject> allSubjects = new LinkedList<Subject>();

    public static void main(String[] args)
    {
        addToList(allSubjects);
        //Skaner do zatrzymywania symulacji
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nacisnij Enter, żeby stworzyć studenta...");
        scanner.nextLine();
        //Stworzenie studenta
        IStudentStatGenerator generator = new StudentGenerator();
        Student janusz= new Student(generator);
        System.out.println("Statystyki studenta: ");
        System.out.println(janusz.printStats());
        //Stworzenie jego planu zajęć
        ArrayList<Subject> plan = new ArrayList<>();
        Random rand = new Random();
        generatePlan(plan, rand, allSubjects);
        //Wydruk planu
        System.out.println("Jego plan to: ");
        for (int i = 0; i < 5; i++)
            System.out.println(dayNames[i] + ": " + plan.get(i));

        System.out.println("\nNacisnij Enter, żeby rozpocząć symulację...");
        scanner.nextLine();

        for (int week = 1; week <= 15; week++)
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
                janusz.removeExpiredStatisticChanges();
                System.out.println("Nacisnij Enter, żeby przejść do następnego dnia...");
                scanner.nextLine();
            }
        }
    }
    public static void addToList(LinkedList<Subject> list)
    {
        //Dodanie przedmiotów do listy z której będą losowane
        list.add(new Subject("Matematyka"));
        list.add(new Subject("Filozofia"));
        list.add(new Subject("Programowanie"));
        list.add(new Subject("Miernictwo"));
        list.add(new Subject("Fizyka"));
    }
    public static void generatePlan(ArrayList<Subject> plan, Random rand, LinkedList<Subject> subjectList)
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
                plan.add(subjectList.getFirst());
                subjectList.removeFirst();
            }
        }
    }
}



