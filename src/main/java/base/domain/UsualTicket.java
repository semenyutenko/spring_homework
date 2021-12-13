package base.domain;

public class UsualTicket implements ITicket{

    private final String question;
    private final String answer;
    private final int points;

    public UsualTicket(String question,
                       String answer,
                       int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
