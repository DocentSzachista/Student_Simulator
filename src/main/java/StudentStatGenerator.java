import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Klasa ma za zadanie wygenerować statystyki Studenta
 */
public class StudentStatGenerator implements IStudentStatGenerator
{
	@Override
	public Map<StatisticType, Integer> generateStats ()
	{
		Random rnd = new Random();
		HashMap<StatisticType, Integer> returnValue = new HashMap<>();
		for(StatisticType stat : StatisticType.values())
			returnValue.put(stat, rnd.nextInt(5) + 5);

		return returnValue;
	}
}
