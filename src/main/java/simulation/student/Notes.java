package simulation.student;

import simulation.subject.Subject;

import java.util.*;

public class Notes
{
    private final Map<Subject, List<Float>> noteBySubject;

    public List<Subject> getSubjects()
    {
        List<Subject> returnList = new LinkedList<>();
        for (Map.Entry<Subject, List<Float>> subject : noteBySubject.entrySet())
        {
            returnList.add(subject.getKey());
        }

        return returnList;
    }

    public Notes() {
        this.noteBySubject = new HashMap<>();
    }

    public void add(simulation.subject.Subject subject, Float note)
    {
        List<Float> currentNotes = noteBySubject.getOrDefault(subject, new ArrayList<>());
        currentNotes.add(note);
        noteBySubject.put(subject, currentNotes);
    }

    public float getAverageFor(Subject subject)
    {
        List<Float> notes = noteBySubject.getOrDefault(subject, new ArrayList<>());

        if (notes.isEmpty())
            return 0f;

        return calculateAverage(notes);
    }

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
