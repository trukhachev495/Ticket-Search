package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    private Ticket ticket1 = new Ticket(1, 3200, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 4500, "DME", "AER", 200);
    private Ticket ticket3 = new Ticket(3, 2900, "DME", "AER", 1440);
    private Ticket ticket4 = new Ticket(4, 3000, "VOZ", "KZN", 800);
    private Ticket ticket5 = new Ticket(5, 5800, "LED", "KZN", 300);
    private Ticket ticket11 = new Ticket(1, 16200, "VOZ", "MOSCOW", 120);
    private Ticket ticket22 = new Ticket(2, 24000, "VOZ", "MOSCOW", 120);
    private Ticket ticket33 = new Ticket(3, 9000, "VOZ", "MOSCOW", 120);


    @Test
    public void add() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket[] actual = repository.getTickets();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void emptyAddition() {
        Ticket[] actual = repository.getTickets();
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void removeId() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);

        Ticket[] actual = repository.removeById(2);
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void deletingIdWithOneAdded() {
        repository.add(ticket5);

        Ticket[] actual = repository.removeById(5);
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void priceComparison() {

        repository.add(ticket1);
        repository.add(ticket2);
        int actual = ticket1.compareTo(ticket2);
        int expected = -1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void sortByPrice() {
        manager.add(ticket11);
        manager.add(ticket22);
        manager.add(ticket33);
        System.out.println(Arrays.toString(manager.findTicketSortedByPrice("VOZ","MOS")));


        Ticket[] actual = manager.findTicketSortedByPrice("VOZ","MOS");
        Ticket[] expected = {ticket33, ticket11,ticket22};
        assertArrayEquals(actual, expected);
    }
}