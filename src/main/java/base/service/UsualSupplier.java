package base.service;

import base.domain.ITicket;
import base.domain.UsualTicket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsualSupplier implements ISupplier{

    String questionList;

    public UsualSupplier(@Value("${questionList}") String questionList) {
        this.questionList = questionList;
    }

    @Override
    public List<ITicket> getTickets() {
        List<ITicket> tickets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(questionList))){
           reader.lines().forEach(s -> {
               String[] strings = s.split(",");
               tickets.add(new UsualTicket(strings[0], strings[1], Integer.parseInt(strings[2])));
           });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
