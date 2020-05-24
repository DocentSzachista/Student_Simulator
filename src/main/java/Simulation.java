import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Student Simulation
 * <p>Program mający za zadanie utworzyć studenta i poddać go próbie przetrwania pierwszego semestru
 * na uczelni. Semestr składa się z 10 tygodni</p>
 * @author Damian Raczkowski
 * @author Jan Malek
 * @version 1.0
 * @since  23-05-2020
 * klasa Simulation odpowiada za stworzenie Studenta, wygenerowanie planu zajęć, wylosowanie wydarzenia
 * po zajęciach oraz przeprowadzenie całej symulacji semestru.
 *
 */
public class Simulation
{
    public static final String[] dayNames = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Weekend"};
    public static List<Subject> allSubjects = new LinkedList<Subject>();
    private static AddEventAfterClassesBase weekendOrAfterClassesBase=new AddEventAfterClassesBase();

    /**
     * Silnik symulacji
     * @param args
     */
    public static void main(String[] args)
    {
        generateSubjects(allSubjects);
        //Stworzenie studenta
        IStudentStatGenerator generator = new StudentStatGenerator();
        Student janusz= new Student(generator);
        System.out.println("Statystyki studenta: ");
        System.out.println(janusz);
        //Stworzenie jego planu zajęć
        List<Subject> plan = new ArrayList<>();
        Random rand = new Random();
        generatePlan(plan, rand, allSubjects);
        //Wydruk planu
        System.out.println("Jego plan to: ");
        for (int i = 0; i < 5; i++)
            System.out.println(dayNames[i] + ": " + plan.get(i));

        simulationLoop(10, janusz, plan);
    }

    /**
     * Dodanie przedmiotow
     * @param list w ktorej są przetrzymywane nazwy przedmiotow
     */
    static void generateSubjects(List<Subject> list)
    {
        //Dodanie przedmiotów do listy z której będą losowane
        list.add(new Subject("Matematyka"));
        list.add(new Subject("Filozofia"));
        list.add(new Subject("Programowanie"));
        list.add(new Subject("Miernictwo"));
        list.add(new Subject("Fizyka"));
    }

    /**
     * Wygenerowanie planu zajec
     * @param plan nazwy przedmiotow uporzadkowane w dniach tygodnia
     * @param rand ziarno losowania
     * @param subjectList nazwy przedmiotow
     */
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

    /**
     * Pętla symulacji
     * @param weeks ilosc tygodni trwania semestru
     * @param student obiekt studenta, na którym przeprowadzana jest symulacja
     * @param plan zajecia przyporzadkowane dniom tygodnia
     */
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
                    eventAfterClassesSimulationPhase(student);
                }
                else
                {
                    System.out.println("Dzisiejsze zajęcia to: " + plan.get(day));
                    ScientificEvent Event= plan.get(day).randomEvent(student);
                    Event.setSubject(plan.get(day));
                    Event.evaluateStudent(student);
                    System.out.println("Obecna średnia z " + plan.get(day) + " to: " + plan.get(day).getScore());
                }
                student.removeExpiredStatisticChanges();
            }
        }
    }


    /**
     * Wylosowanie wydarzenia po zajeciach i sprawdzenie czy przebieglo ono dla studenta pomyslnie
     * @param student od ktorego będzie pobierana statystyka
     */
    static public  void eventAfterClassesSimulationPhase(Student student)
    {
        List<EventAfterClasses> events = weekendOrAfterClassesBase.getListAfterSchool();
        Random randomize= new Random();
        int index= randomize.nextInt(events.size() - 1) + 1;
        EventAfterClasses event = events.get(index);
        events.set(index, events.get(0));
        events.set(0, event);
        event.evaluateStudent(student);
    }
}



