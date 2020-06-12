package simulation.event;

import simulation.student.Student;
import simulation.subject.Subject;

/**
 * Interfejs Event służący do przeprowadzania wydarzeń
 */
public interface Event {
    void apply(Student student, Subject subject);
}
