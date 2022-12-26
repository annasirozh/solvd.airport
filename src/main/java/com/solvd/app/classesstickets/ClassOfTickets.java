package com.solvd.app.classesstickets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class ClassOfTickets {

    static final Logger LOGGER = LogManager.getLogger(ClassOfTickets.class);

    TicketClass nameOfClassTicket;
    private int maxWeightHandLuggage;
    private int ticketFare;
    private int countOfPlacesForHandLuggage;

    public ClassOfTickets(TicketClass nameOfClassTicket, int maxWeightHandLuggage, int ticketFare, int countOfplacesForHandLuggage) {
        this.nameOfClassTicket = nameOfClassTicket;
        this.maxWeightHandLuggage = maxWeightHandLuggage;
        this.ticketFare = ticketFare;
        this.countOfPlacesForHandLuggage = countOfplacesForHandLuggage;
    }


    public TicketClass getNameOfClassTicket() {
        return nameOfClassTicket;
    }

    public void setNameOfClassTicket(TicketClass nameOfClassTicket) {
        this.nameOfClassTicket = nameOfClassTicket;
    }

    public int getMaxWeightHandLuggage() {
        return maxWeightHandLuggage;
    }

    public void setMaxWeightHandLuggage(int maxWeightHandLuggage) {
        this.maxWeightHandLuggage = maxWeightHandLuggage;
    }

    public int getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(int ticketFare) {
        this.ticketFare = ticketFare;
    }

    public int getCountOfplacesForHandLuggage() {
        return countOfPlacesForHandLuggage;
    }

    public void setCountOfplacesForHandLuggage(int countOfplacesForHandLuggage) {
        this.countOfPlacesForHandLuggage = countOfplacesForHandLuggage;
    }

    @Override
    public String toString() {
        return "ClassOfTickets{" +
                "nameOfClassTicket=" + nameOfClassTicket +
                ", maxWeightHandLuggage=" + maxWeightHandLuggage +
                ", ticketFare=" + ticketFare +
                ", countOfplacesForHandLuggage=" + countOfPlacesForHandLuggage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassOfTickets)) return false;
        ClassOfTickets that = (ClassOfTickets) o;
        return maxWeightHandLuggage == that.maxWeightHandLuggage && ticketFare == that.ticketFare
                && countOfPlacesForHandLuggage == that.countOfPlacesForHandLuggage && nameOfClassTicket == that.nameOfClassTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfClassTicket, maxWeightHandLuggage, ticketFare, countOfPlacesForHandLuggage);
    }

    public void displayInformationAboutClassOfTickets() {
        LOGGER.info("Name of class ticket: %s \n, Max weight hand Luggage: %d \n, Ticket fare: %d" +
                " \n,Count of places for hand luggage: %d \n", nameOfClassTicket, maxWeightHandLuggage, ticketFare,
                countOfPlacesForHandLuggage);
        //System.out.printf("Name of class ticket: %s \n, Max weight hand Luggage: %d \n, Ticket fare: %d \n,Count of places for hand luggage: %d \n", nameOfClassTicket,maxWeightHandLuggage,ticketFare,countOfplacesForHandLuggage);
    }

}
