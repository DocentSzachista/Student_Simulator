public abstract class EventBase
{
    protected String description;
    protected int requirements;
    protected StatisticType typeOfStatistic;
    public void  setDescription(String description)
    {
        this.description=description;
    }
    public abstract void evaluateStudent(Student student);
}
