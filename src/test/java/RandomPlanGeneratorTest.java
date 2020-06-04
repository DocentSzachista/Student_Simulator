import org.junit.Assert;
import org.junit.Test;


import simulation.event.EventsDatabase;
import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.plan.RandomPlanGenerator;
import simulation.student.StatisticType;
import simulation.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class RandomPlanGeneratorTest {
    @Test
    public void RandomPlanGeneratorTest() {
        List<Subject> availableSubjects = new ArrayList<>();
        EventsDatabase database = new EventsDatabase();

        availableSubjects.add(new Subject("Matematyka", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Filozofia", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Programowanie", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Miernictwo", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Fizyka", database.getSchoolEvents()));
        RandomPlanGenerator planGenerator = new RandomPlanGenerator(availableSubjects);
        Plan plan = planGenerator.generate(0);

        Assert.assertTrue(plan.getSubjectsFor(Day.MONDAY).toString().contains("Matematyka"));
        Assert.assertTrue(plan.getSubjectsFor(Day.TUESDAY).toString().contains("Fizyka"));
        Assert.assertTrue(plan.getSubjectsFor(Day.WEDNESDAY).toString().contains("Programowanie"));
        Assert.assertTrue(plan.getSubjectsFor(Day.THURSDAY).toString().contains("Miernictwo"));
        Assert.assertTrue(plan.getSubjectsFor(Day.FRIDAY).toString().contains("Filozofia"));

    }
}
