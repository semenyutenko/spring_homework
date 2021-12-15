package base.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsualResultCounterTest {

    private IResultCounter counter;

    @BeforeEach
    private void setUp() {
        counter = new UsualResultCounter();
    }

    @ParameterizedTest(name = "amount of questions {0} and points {1}")
    @CsvSource({
            "10, 10, 1.0",
            "3, 10, 3.33",
            "25, 12, 0.48"
    })
    @DisplayName("ResultCounter returns a correct result")
    void shouldReturnCorrectResults(int amount, int points, double expected) {
        assertEquals(expected, counter.getResult(amount, points));
    }


}