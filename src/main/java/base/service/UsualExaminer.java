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
        Map<String, Double> results = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        List<ITicket> tickets = supplier.getTickets();
        String name = greetingMaker.getName();
        while (!name.equals("stop")){
            int currentAmount = 0;
            int score = 0;
            Collections.shuffle(tickets);
            for (ITicket ticket : tickets) {
                System.out.println(ticket.getQuestion() + ":");
                String answer = scanner.nextLine();
                if (answer.equals("stop")) break;
                currentAmount++;
                if (checker.isRight(ticket, answer)) score += ticket.getPoints();
                if (currentAmount != 0 && currentAmount == amountQuestions) break;
            }
            Double result = resultCounter.getResult(amountQuestions, score);
            System.out.println("Test is finished. Your score is: " + result);
            results.put(name, result);
            name = greetingMaker.getName();
        }
        scanner.close();
        return results;
    }
}
