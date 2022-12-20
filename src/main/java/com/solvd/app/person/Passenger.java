package com.solvd.app.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Passenger extends Person {

    static final Logger logger = LogManager.getLogger(Passenger.class.getName());
    private int numberOfPassport;

    public Passenger(String nameOfPerson, String surnameOfPerson, int numberOfPassport) {
        super(nameOfPerson, surnameOfPerson);
        this.numberOfPassport = numberOfPassport;
    }

    public int getNumberOfPassport() {
        return numberOfPassport;
    }

    public void setNumberOfPassport(int numberOfPassport) {
        this.numberOfPassport = numberOfPassport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return numberOfPassport == passenger.numberOfPassport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPassport);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "numberOfPassport=" + numberOfPassport +
                '}';
    }

    @Override
    public void displayInformationAboutPerson() {
        logger.info("Passenger name: {} \t Passenger surname: {} \n Passenger numberOfPassport: {} \n", super.getNameOfPerson(), super.getSurnameOfPerson(),numberOfPassport);

    }
}
