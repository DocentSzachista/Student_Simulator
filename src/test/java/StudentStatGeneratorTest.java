import org.junit.Test;
import org.junit.Assert;
import simulation.student.StatisticType;
import simulation.student.StudentStatGenerator;

import java.util.Map;

public class StudentStatGeneratorTest
{
	@Test
	public void StatGeneratorTest()
	{
		StudentStatGenerator generator = new StudentStatGenerator();
		Map<StatisticType, Integer> stats = generator.generate(0);

		Assert.assertTrue(stats.get(StatisticType.Spryt) == 9);
		Assert.assertTrue(stats.get(StatisticType.Inteligencja) == 5);
		Assert.assertTrue(stats.get(StatisticType.Lenistwo) == 8);
	}
}
