package base.service;

import org.springframework.stereotype.Service;

@Service
public class UsualResultCounter implements IResultCounter {
    @Override
    public Double getResult(int amountQuestions, int points) {
        return (points * 100 / amountQuestions) / 100.0;
    }
}
