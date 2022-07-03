package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String departureIATA;
    protected String arrivalIATA;
    protected int TravelTime;

    public Ticket(int id, int price, String departureIATA, String arrivalIATA, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureIATA = departureIATA;
        this.arrivalIATA = arrivalIATA;
        TravelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureIATA() {
        return departureIATA;
    }

    public void setDepartureIATA(String departureIATA) {
        this.departureIATA = departureIATA;
    }

    public String getArrivalIATA() {
        return arrivalIATA;
    }

    public void setArrivalIATA(String arrivalIATA) {
        this.arrivalIATA = arrivalIATA;
    }

    public int getTravelTime() {
        return TravelTime;
    }

    public void setTravelTime(int travelTime) {
        TravelTime = travelTime;
    }

    @Override
    public String toString() {
        String x = String.valueOf((price));
        return x;
    }

    @Override
    public int compareTo(Ticket price1) {
        if (price < price1.price) {
            return -1;
        }
        if (price > price1.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && TravelTime == ticket.TravelTime && Objects.equals(departureIATA, ticket.departureIATA) && Objects.equals(arrivalIATA, ticket.arrivalIATA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departureIATA, arrivalIATA, TravelTime);
    }
}
