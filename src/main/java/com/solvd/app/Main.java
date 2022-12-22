package com.solvd.app;

import com.solvd.app.classesstickets.ClassOfTickets;
import com.solvd.app.classesstickets.TicketClass;
import com.solvd.app.countries.Country;
import com.solvd.app.exceptions.EFoundFlightISNULL;
import com.solvd.app.exceptions.ENameOfCountryIsNULL;
import com.solvd.app.fileReader.FileIsReader;
import com.solvd.app.flight.Flight;
import com.solvd.app.functionalInterface.*;
import com.solvd.app.myLinkedList.MyOwnLinkedlist;
import com.solvd.app.person.Passenger;
import com.solvd.app.person.Pilot;
import com.solvd.app.plane.Plane;
import com.solvd.app.tickets.Ticket;
import com.solvd.app.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;
import java.util.function.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParseException, IOException, EFoundFlightISNULL {
        // подсчет уникальных значений
        FileIsReader.countTheNumberOfUniqueWordsInAFile();
        FileIsReader.reverseReaderFile();

        //работа с собственным linkedlist
        MyOwnLinkedlist<String> list = new MyOwnLinkedlist<>();
        list.addFirst("1");
        list.addFirst("2");
        list.addLast("3");
        list.print();
        list.addByIndex(1, "6");
        list.print();
        LOGGER.info(list.getSize());
        list.setByIndex(2, "7");
        LOGGER.info(list.getByINdex(0));
        list.print();

        //Использование собственного функционального интерфейса MFunction
        MFunction<String, Integer> converterValue = x -> Integer.valueOf(x);
        LOGGER.info("Converter value: " + converterValue.apply(list.getByINdex(2)));

        //Использование собственного функционального интерфейса MCheck
        MCheck<Integer> result = x -> x > 0;
        LOGGER.info("Check: " + result.get(converterValue.apply(list.getByINdex(1))));

        List<Country> countries = Utils.createListOfCountry();

        //использование функционального интерфейса Supplier
        Supplier<Country> randomNameOfCountry = () -> {
            int value = (int) (Math.random() * countries.size());
            return countries.get(value);
        };
        LOGGER.info("Random country{}: ", randomNameOfCountry.get());

        LinkedList<Pilot> pilots = Utils.createPilotList();
        LOGGER.info("List Of pilot {}:", pilots);

        List<Flight> flights = Utils.addFlights(countries);
        Map<TicketClass, ClassOfTickets> classOfTicketsMap = Utils.addClassTicket();

        HashSet<Plane> planes = Utils.createPlaneList();
        LOGGER.info("List of available aircraft {}:", planes);

        List<Passenger> passengers = Utils.createPassengerList();
        LOGGER.info("List of passengers");

        Scanner in = new Scanner(System.in);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LOGGER.info("Enter country:");
        final String nameOfCountry = reader.readLine();

        if (nameOfCountry.trim().length() == 0) {
            try {
                throw new ENameOfCountryIsNULL ("Error:You have not entered a country");
            } catch (ENameOfCountryIsNULL e) {
                throw new RuntimeException(e);
            }
        } else {
            LOGGER.info("Our country is: " + nameOfCountry);
        }

        Flight foundFlight = Utils.searchOfFlight(flights, nameOfCountry);
        int price;
        // использование функционального интерфейса Predicate
        Predicate<Flight> isFlightNotEmpty = x -> x != null;
        if (isFlightNotEmpty.test(foundFlight)) {
            LOGGER.info("Your flight:");
            foundFlight.displayInformation();
            LOGGER.info("Check out the rate: Economy,Comfort, Business...");
            TicketClass ticketClass = TicketClass.valueOf(reader.readLine().toUpperCase());
            LOGGER.info("Our ticket class is: " + ticketClass);
            ClassOfTickets readTicketClass = classOfTicketsMap.get(ticketClass);
            price = Utils.getPriceOfFlight(foundFlight, readTicketClass);

            //использование функционального оператора UnaryOperator
            UnaryOperator<Integer> resultOfPrice = x -> x * 2;
            LOGGER.info("Result price: " + resultOfPrice.apply(price));
        } else {
            throw new EFoundFlightISNULL("This country is not in the list of flights");
        }
        LOGGER.info("Do you want to buy a ticket? Enter 1 if yes, 0 if no.");
        int decisionVariable = in.nextInt();

        //использование функционального интерфейса IntFunction
        IntFunction<Integer> decisionVariable1 = x -> x;
        if (decisionVariable1.apply(decisionVariable) == 1) {
            LOGGER.info("Put your name:");
            String nameOfPassenger = in.next();
            LOGGER.info("Put your surname:");
            String surnamePassenger = in.next();

            //Использование функционального интерфейса Consumer
            Consumer<String> inputNamePassenger = x -> LOGGER.info("Hello" + x + "!");
            inputNamePassenger.accept(nameOfPassenger);

            LOGGER.info("Put passport number:");
            int numberOfPassport = in.nextInt();

            Optional<Plane> randomPlane = Utils.getAPlaneFromTheList(planes);

           // Plane plane1 = new Plane(345, 6125, 590);
            Passenger passenger = Utils.addPassengerToList(nameOfPassenger,surnamePassenger,numberOfPassport,passengers);
            LOGGER.info(passenger);
            Ticket ticket = Utils.createTicketList(234, foundFlight, randomPlane, passenger,price);
            LOGGER.info("Our ticket:" + ticket);
            long count = Utils.countHowManyTimesThePassengerUsedTheAirline(passengers,passenger);
            LOGGER.info(count);
        } else {
            LOGGER.info("Come back to us next time:)");
        }

    }
}
