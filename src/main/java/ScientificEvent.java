public class ScientificEvent extends EventBase{
    private Subject subject;
  public ScientificEvent(String description, StatisticType typeOfStatistic, int requirements ){
      this.description=description;
      this.typeOfStatistic=typeOfStatistic;
      this.requirements=requirements;
  }

    @Override
    public void evaluateStudent(Student student) {
        if( student.getStatistic(typeOfStatistic)>requirements)
        {
            switch(student.getStatistic(typeOfStatistic)-requirements){
                case 1: subject.addMark(3);
                case 2: subject.addMark(4);
                case 3: subject.addMark(5);
            }
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
