package base.service;

import base.domain.ITicket;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsualSupplierTest {

    @Test
    void getTickets() {
        ISupplier supplier = new UsualSupplier("src/main/resources/tickets.csv");
        List<ITicket> tickets = supplier.getTickets();
        assertNotNull(tickets);
        assertInstanceOf(Set.class, tickets);
    }
}