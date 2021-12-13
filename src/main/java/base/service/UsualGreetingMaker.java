package base.service;

import java.util.Scanner;

public class UsualGreetingMaker implements IGreetingMaker {
    private final String greeting;

    public UsualGreetingMaker(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting);
        return scanner.nextLine();
    }
}
