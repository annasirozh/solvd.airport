package com.solvd.app.plane;


import com.solvd.app.person.Pilot;

public class PassengerPlane extends Plane {

    private int numberOfSeats;
    private Pilot pilot;
    public PassengerPlane(int modelPlane, int maxSpeedPlane, int maxWeight, int numberOfSeats, Pilot pilot) {
        super(modelPlane, maxSpeedPlane, maxWeight);
        this.numberOfSeats = numberOfSeats;
        this.pilot = pilot;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }



}
