package simulation.student;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Klasa ma za zadanie wygenerować statystyki Studenta
 */
public class StudentStatGenerator
{
	public Map<StatisticType, Integer> generate()
	{
		return generateInternal(System.currentTimeMillis());
	}

	public Map<StatisticType, Integer> generate(long seed)
	{
		return generateInternal(seed);
	}

	public Map<StatisticType, Integer> generateInternal(long seed)
	{
		Random rnd = new Random(seed);
		HashMap<StatisticType, Integer> returnValue = new HashMap<>();
		for (StatisticType stat : StatisticType.values())
			returnValue.put(stat, rnd.nextInt(5) + 5);

		return returnValue;
	}
}
