package com.solvd.app.reflection;

public class Order {
    private int numberOfOrder;
    private int numberOfTicket;
    private boolean paymentState;

    public Order(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;

    }

    public int getInformation(int numberOfOrder){
        System.out.println("bdjhbhj");
        return numberOfOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numberOfOrder=" + numberOfOrder +
                ", numberOfTicket=" + numberOfTicket +
                ", paymentState=" + paymentState +
                '}';
    }
}
