package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tickets1 = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tickets1[i] = tickets[i];
        }
        tickets1[tickets1.length - 1] = ticket;
        tickets = tickets1;
    }
    public Ticket[] getTickets() {
        return tickets;
    }

    public Ticket[] removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        tickets = tmp;
        return tmp;
    }
}
