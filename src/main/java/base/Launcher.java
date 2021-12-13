package base;

import base.service.IExaminer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;

public class Launcher {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("base.xml");
        IExaminer examiner = context.getBean("examiner", IExaminer.class);
        Map<String, Double> map = examiner.getResults();
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingDouble((ToDoubleFunction<Map.Entry<String, Double>>) Map.Entry::getValue)
                .reversed());
        System.out.println("RESULTS");
        System.out.println("******************************");
        list.forEach(e -> {
            System.out.println(e.getKey() + " got: " + e.getValue() + " points");
        });
    }
}
