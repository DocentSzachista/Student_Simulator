package simulation.event;

import simulation.student.Student;
import simulation.subject.Subject;

public interface Event {

    void apply(Student student, Subject subject);
}
