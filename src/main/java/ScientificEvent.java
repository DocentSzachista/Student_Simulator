public class ScientificEvent extends EventBase{
  public ScientificEvent(String description, StatisticType typeOfStatistic, int requirements ){
      this.description=description;
      this.typeOfStatistic=typeOfStatistic;
      this.requirements=requirements;
  }

    @Override
    public void evaluateStudent(Student student) {
        if( student.getStatistic(typeOfStatistic)>requirements)
        {

        }
        else
        {

        }

    }
}
