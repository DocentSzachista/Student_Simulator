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
        //Dodanie przedmiotów do listy z której będą losowane
        allSubjects.add(new Subject("Matematyka"));
        allSubjects.add(new Subject("Filozofia"));
        allSubjects.add(new Subject("Programowanie"));
        allSubjects.add(new Subject("Miernictwo"));
        allSubjects.add(new Subject("Fizyka"));
        //Skaner do zatrzymywania symulacji
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nacisnij Enter, żeby stworzyć studenta...");
        scanner.nextLine();
        //Stworzenie studenta
        IStudentStatGenerator generator = new StudentGenerator();
        Student Janusz= new Student(generator);
        System.out.println("Statystyki studenta: ");
        System.out.println(Janusz.printStats());
        //Stworzenie jego planu zajęć
        ArrayList<Subject> plan = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++)
        {
            int range = allSubjects.size() - 1;
            if(range > 1)
            {
                int subjectIndex = rand.nextInt(range);
                plan.add(allSubjects.get(subjectIndex));
                allSubjects.remove(subjectIndex);
            }
            else
            {
                plan.add(allSubjects.getFirst());
                allSubjects.removeFirst();
            }
        }
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
                Janusz.removeExpiredStatisticChanges();
                System.out.println("Nacisnij Enter, żeby przejść do następnego dnia...");
                scanner.nextLine();
            }
        }
    }
}



