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
        System.out.println(description);
        int statDifference = student.getStatistic(typeOfStatistic) - requiredStatistic;
        if(statDifference >= 0)
        {
            int markToAdd = 3;
            if(statDifference >= requiredStatistic)
                markToAdd = 5;
            else if((float)statDifference >= (float)requiredStatistic * .5f)
                markToAdd = 4;

            subject.addMark(markToAdd);
            System.out.println("Udało się, otrzymałeś ocene: " + markToAdd);
        }
        else
        {
            subject.addMark(2);
            System.out.println("Nie udało się, otrzymałeś ocene: 2");
        }
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
