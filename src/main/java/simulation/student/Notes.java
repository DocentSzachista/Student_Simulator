package simulation.student;

import simulation.subject.Subject;

import java.util.*;

/**
 * Klasa przechowująca oceny studenta z każdego przedmiotu
 */
public class Notes
{
    private final Map<Subject, List<Float>> noteBySubject;

    /**
     * Metoda zwracająca listę przedmiotów
     * @return lista przedmiotów
     */
    public List<Subject> getSubjects()
    {
        List<Subject> returnList = new LinkedList<>();
        for (Map.Entry<Subject, List<Float>> subject : noteBySubject.entrySet())
        {
            returnList.add(subject.getKey());
        }

        return returnList;
    }

    /**
     * Konstruktor tworzący instację klasy
     */
    public Notes() {
        this.noteBySubject = new HashMap<>();
    }

    /**
     * Metoda dodająca ocenę do danego przedmiotu
     * @param subject przedmiot do którego dodajemy ocenę
     * @param note ocena jaka ma zostać dodana do przedmiotu
     */
    public void add(simulation.subject.Subject subject, Float note)
    {
        List<Float> currentNotes = noteBySubject.getOrDefault(subject, new ArrayList<>());
        currentNotes.add(note);
        noteBySubject.put(subject, currentNotes);
    }

    /**
     * Metoda zwracająca średnią ocen z przedmiotu
     * @param subject przedmiot, z którego ma zostać zwrócona średnia ocen
     * @return średnia ocen
     */
    public float getAverageFor(Subject subject)
    {
        List<Float> notes = noteBySubject.getOrDefault(subject, new ArrayList<>());

        if (notes.isEmpty())
            return 0f;

        return calculateAverage(notes);
    }

    /**
     * Metoda wyliczająca średnią ocen z przedmiotu i podająca ją do metody getAverageFor.
     * @param notes lista ocen
     * @return średnia ocen
     */
    private float calculateAverage(List<Float> notes)
    {
        float sum = 0f;
        int amount = 0;
        for (Float note : notes)
        {
            sum += note;
            amount++;
        }
        return Math.round(sum / amount * 100f) / 100f;
    }
}
