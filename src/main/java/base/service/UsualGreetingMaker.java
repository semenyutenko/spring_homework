package base.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UsualGreetingMaker implements IGreetingMaker {

    private final String greeting;

    public UsualGreetingMaker(@Value("${greeting}") String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(greeting);
        return scanner.nextLine();
    }
}
