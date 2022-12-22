package com.solvd.app.utils;

import com.solvd.app.classesstickets.ClassOfTickets;
import com.solvd.app.classesstickets.TicketClass;
import com.solvd.app.countries.Country;
import com.solvd.app.flight.Flight;
import com.solvd.app.person.Passenger;
import com.solvd.app.person.Pilot;
import com.solvd.app.plane.Plane;
import com.solvd.app.tickets.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

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

    public static Flight findACheapFlight(List<Flight> flights) {

        /*Optional<Flight> cheapFlight = flights.stream().filter((flightElement)->min.flightElement.min(String::compareTo).get()
        Flight resultCheapFlight = cheapFlight.get();
        return resultCheapFlight;
        //collection.stream().min(String::compareTo).get()*/
        return null;
    }

    public static Flight searchOfFlight(List<Flight> flights, String nameOfCountry) {

        /*for (Flight flight : flights) {
            if (nameOfCountry.equals(flight.getDestination().getName())) {
                return flight;
            }
        }
        return null;*/

        // Stream  с терминальной операцией(2)
        Optional<Flight> flight = flights.stream().filter((flightElement) -> flightElement.getDestination().getName().equals(nameOfCountry)).findFirst();
        Flight flight1 = flight.get();
        return flight1;
    }

    public static Map<TicketClass, ClassOfTickets> addClassTicket() {
        return Map.of(TicketClass.BUSINESS, new ClassOfTickets(TicketClass.BUSINESS, 15, 250, 2),
                TicketClass.COMFORT, new ClassOfTickets(TicketClass.COMFORT, 10, 150, 2),
                TicketClass.ECONOMY, new ClassOfTickets(TicketClass.ECONOMY, 5, 50, 1));
    }

    public static List<Country> createListOfCountry() {

        //использование stream (3)
        List<Country> countries = Arrays.asList(new Country("Belarus", "Minsk"), new Country("Poland", "Warshawa"), new Country("Russia", "Sochi"));
        Stream<Country> countryStream = countries.stream();
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

    public static int getPriceOfFlight(Flight foundFlight, ClassOfTickets classOfTickets) {
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

    public static Optional<Plane> getAPlaneFromTheList(HashSet<Plane> planes) {
        //использование терминальной операции findAny StreamAPI(4)
        Optional<Plane> anyPlane = planes.stream().findAny();
        anyPlane.get();
        return anyPlane;
    }

    public static List<Passenger> createPassengerList() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Anna", "Sirozh", 2345));
        passengers.add(new Passenger("Pavel", "Makarski", 5674));
        return passengers;
    }

    public static long countHowManyTimesThePassengerUsedTheAirline(List<Passenger> passengers, Passenger passenger) {
        //использование конвейерного stream переходящего в терминальный(5)
        long count = passengers.stream().filter(passenger::equals).count();
        return count;
    }

    public static Passenger addPassengerToList(String name, String surname, int number, List<Passenger> passengers) {
        Passenger passenger = new Passenger(name, surname, number);
        passengers.add(passenger);
        return passenger;
    }

    public static Ticket createTicketList(int numberOfTicket, Flight flight, Optional<Plane> plane, Passenger passenger, int price) {
        Ticket ticket = new Ticket(numberOfTicket, flight, plane, passenger, price);
        return ticket;
    }
}
