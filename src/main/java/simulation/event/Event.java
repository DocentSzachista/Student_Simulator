package simulation.event;

import simulation.student.Student;

public interface Event {

    void apply(Student student);
}
