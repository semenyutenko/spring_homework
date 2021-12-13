package base.service;

public class UsualResultCounter implements IResultCounter {
    @Override
    public Double getResult(int amountQuestions, int points) {
        return Math.ceil(points * 100 / amountQuestions) / 100;
    }
}
