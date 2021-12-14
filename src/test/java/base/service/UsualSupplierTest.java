package base.service;

import base.domain.ITicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsualSupplierTest {

    @Test
    @DisplayName("Supplier returns List, and it's not empty")
    void getTickets() {
        //given
        ISupplier supplier = new UsualSupplier("src/test/resources/tickets.csv");
        List<ITicket> tickets = supplier.getTickets();

        //then
        assertAll(
                () -> assertNotNull(tickets),
                () -> assertInstanceOf(List.class, tickets)
        );
    }
}