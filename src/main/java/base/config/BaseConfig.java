package base.config;

import base.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:prop.properties")
public class BaseConfig {

    @Value("${greeting}")
    String greeting;

    @Value("${questionList}")
    String questionList;

    @Value("${amountQuestions}")
    int amountQuestions;   //values

    @Bean
    IChecker checker() {
        return new UsualChecker();
    }

    @Bean
    IGreetingMaker greetingMaker() {
        return new UsualGreetingMaker(greeting);
    }

    @Bean
    IResultCounter resultCounter() {
        return new UsualResultCounter();
    }

    @Bean
    ISupplier supplier() {
        return new UsualSupplier(questionList);
    }

    @Bean
    IExaminer examiner() {
        return new UsualExaminer(supplier(), checker(), greetingMaker(), resultCounter(), amountQuestions);
    } //beans
}
