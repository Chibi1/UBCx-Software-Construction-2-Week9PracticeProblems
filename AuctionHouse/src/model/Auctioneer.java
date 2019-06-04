package model;

import observer.Subject;

public class Auctioneer extends Subject {
    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        this.name = name;
    }

    //getters
    public String getName() { return name; }
    public double getCurrentBid() { return currentBid; }

    public void acceptBid(double bid) {
        if (bid < this.currentBid) {
            System.out.println("That bid ins't larger than the current bid?");
        } else {
            this.currentBid = bid;
            notifyObservers(this, currentBid);
        }
    }
}
