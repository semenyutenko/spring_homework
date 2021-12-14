package base.service;

import base.domain.ITicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsualCheckerTest {

    private ITicket ticket = null;
    private IChecker checker = null;

    @BeforeEach
    private void setUp(){
        ticket = mock(ITicket.class);
        checker = new UsualChecker();
    }

    @Test
    @DisplayName("Checker returns true if the answer is correct")
    void shouldReturnRightIfAnswerIsCorrect() {
        //given
        when(ticket.getAnswer()).thenReturn("cat");
        String answer = "cat";
        //when
        boolean isRight = checker.isRight(ticket, answer);
        //then
        assertTrue(isRight);
    }
}