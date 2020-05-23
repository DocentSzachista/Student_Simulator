public class ScientificEvent extends EventBase{
    private Subject subject;
  public ScientificEvent(String description, StatisticType typeOfStatistic, int requirements ){
      this.description=description;
      this.typeOfStatistic=typeOfStatistic;
      this.requiredStatistic=requirements;
  }

    @Override
    public void evaluateStudent(Student student)
    {
        int statDifference = student.getStatistic(typeOfStatistic) - requiredStatistic;
        if(statDifference >= 0)
        {
            if(statDifference >= requiredStatistic)
                subject.addMark(5);
            else if((float)statDifference >= (float)requiredStatistic * .5f)
                subject.addMark(4);
            else
                subject.addMark(3);
        }
        else
        {
            subject.addMark(2);
        }
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
