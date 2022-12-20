package com.solvd.app.utils;

import com.solvd.app.classesstickets.ClassOfTickets;
import com.solvd.app.classesstickets.TicketClass;
import com.solvd.app.countries.Country;
import com.solvd.app.flight.Flight;
import com.solvd.app.person.Passenger;
import com.solvd.app.person.Person;
import com.solvd.app.person.Pilot;
import com.solvd.app.plane.Plane;
import com.solvd.app.tickets.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static List<Flight> addFlights(List<Country> countries) throws ParseException {
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight(countries.get(0), countries.get(1), 867,
                dateFormat.parse("27.12.2022"), "08:00", dateFormat.parse("28.12.2022"),
                12, 8262);
        Flight flight2 = new Flight(countries.get(0), countries.get(2), 967,
                dateFormat.parse("14.12.2022"), "16:00", dateFormat.parse("15.12.2022"),
                8, 9500);
        flights.add(flight1);
        flights.add(flight2);
        return flights;
    }

    public static Flight searchOfFlight(List<Flight> flights, String nameOfCountry) {
        for (Flight flight : flights) {
            if (nameOfCountry.equals(flight.getDestination().getName())) {
                return flight;
            }
        }
        return null;
    }

    public static Map<TicketClass, ClassOfTickets> addClassTicket() {
        return Map.of(TicketClass.BUSINESS, new ClassOfTickets(TicketClass.BUSINESS, 15, 250, 2),
                TicketClass.COMFORT, new ClassOfTickets(TicketClass.COMFORT, 10, 150, 2),
                TicketClass.ECONOMY, new ClassOfTickets(TicketClass.ECONOMY, 5, 50, 1));
    }

    public static List<Country> createListOfCountry() {

        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Belarus", "Minsk"));
        countries.add(new Country("Poland", "Warshawa"));
        countries.add(new Country("Russia", "Sochi"));

        return countries;
    }

    public static LinkedList<Pilot> createPilotList() {
        LinkedList<Pilot> pilots = new LinkedList<>();
        Pilot pilot1 = new Pilot("Павел", "Кичкайло", "high");
        Pilot pilot2 = new Pilot("Василий", "Зарницкий", "high");
        pilots.add(pilot1);
        pilots.add(pilot2);
        return pilots;
    }

    public static final int getPriceOfFlight(Flight foundFlight, ClassOfTickets classOfTickets) {
        int price = foundFlight.getPrice() + classOfTickets.getTicketFare();
        return price;
    }

    public static HashSet<Plane> createPlaneList() {

        HashSet<Plane> planes = new HashSet<>();
        Plane plane1 = new Plane(345, 6125, 590);
        Plane plane2 = new Plane(2345, 7200, 769);
        planes.add(plane1);
        planes.add(plane2);
        return planes;
    }

    public static Passenger createPassengerList(String name, String surname,int number)
    {
        Passenger passenger = new Passenger(name,surname,number);
        /*List<Person> passengers = new ArrayList<>();
        passengers.add(new Passenger(surname,name,number));*/
        return passenger;
    }
    public static Ticket createTicketList(int numberOfTicket, Flight flight, Plane plane, Passenger passenger, int price)
    {
        Ticket ticket=new Ticket(numberOfTicket, flight,plane, passenger,price);
        return ticket;

    }
}
