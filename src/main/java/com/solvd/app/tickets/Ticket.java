package com.solvd.app.tickets;

import com.solvd.app.classesstickets.ClassOfTickets;
import com.solvd.app.classesstickets.TicketClass;
import com.solvd.app.flight.Flight;
import com.solvd.app.person.Passenger;
import com.solvd.app.plane.Plane;

public class Ticket {

    private int numberOfTicket;
    private Flight flight;
    private Plane plane;
    private Passenger passenger;
    private int price;

    public Ticket(int numberOfTicket, Flight flight, Plane plane, Passenger passenger, int price) {
        this.numberOfTicket = numberOfTicket;
        this.flight = flight;
        this.plane = plane;
        this.passenger = passenger;
        this.price = price;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numberOfTicket=" + numberOfTicket +
                ", flight=" + flight +
                ", plane=" + plane +
                ", passenger=" + passenger +
                ", price=" + price +
                '}';
    }
}