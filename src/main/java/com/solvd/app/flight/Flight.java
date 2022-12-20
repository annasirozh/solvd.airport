package com.solvd.app.flight;

import com.solvd.app.DisplayInformation;
import com.solvd.app.countries.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Objects;

public class Flight implements DisplayInformation {

    static final Logger LOGGER = LogManager.getLogger(Flight.class.getName());

    private Country departure;
    private Country destination;
    private int distance;
    private Date departureDate; //LocalDate, LocalTime
    private String departureTime;
    private Date arrivalDate;
    private int travelTime;
    private int price;

    public Flight(Country departure, Country destination, int distance, Date departureDate, String departureTime, Date arrivalDate, int travelTime, int price) {
        this.departure = departure;
        this.destination = destination;
        this.distance = distance;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.travelTime = travelTime;
        this.price = price;
    }

    public Country getDeparture() {
        return departure;
    }

    public void setDeparture(Country departure) {
        this.departure = departure;
    }

    public Country getDestination() {
        return destination;
    }

    public void setDestination(Country destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departure=" + departure +
                ", destination=" + destination +
                ", distance=" + distance +
                ", departureDate=" + departureDate +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", travelTime=" + travelTime +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return distance == flight.distance && travelTime == flight.travelTime && price == flight.price && Objects.equals(departure, flight.departure) && Objects.equals(destination, flight.destination) && Objects.equals(departureDate, flight.departureDate) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalDate, flight.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, destination, distance, departureDate, departureTime, arrivalDate, travelTime, price);
    }

    @Override
    public void displayInformation() {
        LOGGER.info("Departure Of Country: {} \n City Of Country: {} \n Country Of Destination: {} \n  City of Destination: {} \n Distance: {} \n " +
                        "Departure Date: {} \n Departure Time {} \n Arrival Date {} \n Travel Time {} \n Price {} \n", departure.getName(), departure.getCity(),
                destination.getName(), destination.getCity(), distance, departureDate, departureTime, arrivalDate, travelTime, price);
    }

}
