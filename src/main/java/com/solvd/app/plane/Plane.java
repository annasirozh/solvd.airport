package com.solvd.app.plane;

import java.util.Objects;

public class Plane {

    private int modelPlane;
    private int maxSpeedPlane;
    private int maxWeight;

    public Plane(int modelPlane, int maxSpeedPlane, int maxWeight) {
        this.modelPlane = modelPlane;
        this.maxSpeedPlane = maxSpeedPlane;
        this.maxWeight = maxWeight;
    }

    public int getModelPlane() {
        return modelPlane;
    }

    public void setModelPlane(int modelPlane) {
        this.modelPlane = modelPlane;
    }

    public int getMaxSpeedPlane() {
        return maxSpeedPlane;
    }

    public void setMaxSpeedPlane(int maxSpeedPlane) {
        this.maxSpeedPlane = maxSpeedPlane;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return modelPlane == plane.modelPlane && maxSpeedPlane == plane.maxSpeedPlane && maxWeight == plane.maxWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelPlane, maxSpeedPlane, maxWeight);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "modelPlane=" + modelPlane +
                ", maxSpeedPlane=" + maxSpeedPlane +
                ", maxWeight=" + maxWeight +
                '}';
    }


}

