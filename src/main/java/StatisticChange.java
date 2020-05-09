public class StatisticChange
{
	private StatisticType statisticToChange;
	private int changeAmount;
	private int daysLeft;

	public StatisticChange(StatisticType statisticToChange, int changeAmount, int removeAfter)
	{
		this.statisticToChange = statisticToChange;
		this.changeAmount = changeAmount;
		this.daysLeft = removeAfter;
	}

	public boolean shouldRemove()
	{
		daysLeft--;
		if(daysLeft <= 0)
			return true;
		else
			return false;
	}

	public int getStatisticChange(StatisticType statistic)
	{
		if(statistic != statisticToChange)
			return 0;

		return changeAmount;
	}
}
