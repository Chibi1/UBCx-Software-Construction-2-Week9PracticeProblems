package model;

import observer.BidderObserver;
import observer.Subject;

import java.util.Random;

public class Bidder implements BidderObserver {
    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid) {
        this.name = name;
        this.maxBid = maxBid;
    }

    //getters
    public String getName() { return name; }
    public double getPersonalBid() { return personalBid; }
    public double getCurrentBid() { return currentBid; }
    public double getMaxBid() { return maxBid; }

    public void makeBid(double bid) {
        Random random = new Random();
        personalBid = bid + 10*random.nextDouble();
    }

    @Override
    public void update(Subject auctioneer, Object bid) {
        this.currentBid = (double) bid;
        if (currentBid < maxBid) {
            makeBid((double) bid);
        } else {
            System.out.println("I cant bid any higher!");
        }
    }
}
