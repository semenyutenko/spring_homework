package base.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UsualGreetingMakerTest {

    private InputStream in;
    private PrintStream out;
    private ByteArrayOutputStream byteArrayOutputStream;
    private UsualGreetingMaker greetingMaker;

    @BeforeEach
    void setUp() {
        in = System.in;
        out = System.out;
        InputStream newIn = new ByteArrayInputStream("test".getBytes());
        System.setIn(newIn);
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        greetingMaker = new UsualGreetingMaker("Hi");
    }

    @AfterEach
    void getBack() {
        System.setIn(in);
        System.setOut(out);
    }

    @Test
    @DisplayName("GreetingMaker returns correct name")
    void shouldReturnNameFromConsole() {
        //when
        String name = greetingMaker.getName();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        //then
        assertAll(
                () -> assertArrayEquals(bytes, "Hi\r\n".getBytes()),
                () -> assertEquals("test", name)
        );
    }
}