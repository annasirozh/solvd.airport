package com.solvd.app.plane;

import java.util.Objects;

public class CargoPlane extends Plane{

    private int maximumVolume;
    private int cargoCompartmentSize;
    private int cargoDoorSize;


    public CargoPlane(int modelPlane, int maxSpeedPlane, int maxWeight, int maximumVolume, int cargoCompartmentSize, int cargoDoorSize) {
        super(modelPlane, maxSpeedPlane, maxWeight);
        this.maximumVolume = maximumVolume;
        this.cargoCompartmentSize = cargoCompartmentSize;
        this.cargoDoorSize = cargoDoorSize;
    }

    public int getMaximumVolume() {
        return maximumVolume;
    }

    public void setMaximumVolume(int maximumVolume) {
        this.maximumVolume = maximumVolume;
    }

    public int getCargoCompartmentSize() {
        return cargoCompartmentSize;
    }

    public void setCargoCompartmentSize(int cargoCompartmentSize) {
        this.cargoCompartmentSize = cargoCompartmentSize;
    }

    public int getCargoDoorSize() {
        return cargoDoorSize;
    }

    public void setCargoDoorSize(int cargoDoorSize) {
        this.cargoDoorSize = cargoDoorSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoPlane)) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return maximumVolume == that.maximumVolume && cargoCompartmentSize == that.cargoCompartmentSize && cargoDoorSize == that.cargoDoorSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maximumVolume, cargoCompartmentSize, cargoDoorSize);
    }
}
