package simulation.student;

import java.util.Map;

public interface IStudentStatGenerator {
	Map<StatisticType, Integer> generate();
}
