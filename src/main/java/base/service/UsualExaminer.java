package base.service;

import base.domain.ITicket;

import java.util.*;

public class UsualExaminer implements IExaminer {

    private final ISupplier supplier;
    private final IChecker checker;
    private final IGreetingMaker greetingMaker;
    private final IResultCounter resultCounter;
    private final int amountQuestions;


    public UsualExaminer(ISupplier supplier,
                         IChecker checker,
                         IGreetingMaker greetingMaker,
                         IResultCounter resultCounter,
                         int amountQuestions) {
        this.supplier = supplier;
        this.checker = checker;
        this.greetingMaker = greetingMaker;
        this.resultCounter = resultCounter;
        this.amountQuestions = amountQuestions;
    }

    @Override
    public Map<String, Double> getResults() {
        Scanner scanner = new Scanner(System.in);
        List<ITicket> tickets = supplier.getTickets();
        Map<String, Double> results = new HashMap<>();
        String name = greetingMaker.getName();
        while (!name.equals("stop")){
            int x = 0;
            int score = 0;
            Collections.shuffle(tickets);
            for (ITicket ticket : tickets) {
                System.out.println(ticket.getQuestion() + ":");
                String answer = scanner.nextLine();
                if (answer.equals("stop") || (x != 0 && x == amountQuestions - 1)) break;
                x++;
                if (checker.isRight(ticket, answer)) score += ticket.getPoints();
            }
            Double result = resultCounter.getResult(x, score);
            System.out.println("Test is finished. Your score is: " + result);
            results.put(name, result);
            name = greetingMaker.getName();
        }
        return results;
    }


}
