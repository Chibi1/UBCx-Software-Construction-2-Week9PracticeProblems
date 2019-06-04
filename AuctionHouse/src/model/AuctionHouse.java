package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuctionHouse {
    private Auctioneer auctioneer;
    private List<Bidder> bidders;
    private static Scanner userInput = new Scanner(System.in);


    public AuctionHouse() {
        bidders = new ArrayList<>();
        populateAuctionHouse();
        startBidding();
    }

    private void startBidding() {
        boolean itemSold = false;
        String userResponse = "";

        System.out.print("Bidding starts at $1.00, enter your initial bid: ");
        auctioneer.acceptBid(userInput.nextDouble());
        displayHighestBid();

        while (!itemSold) {
            System.out.println("\nWould you like to bid again? (y/n): ");
            userResponse = userInput.next();

            if (userResponse.equalsIgnoreCase("y")) {
                System.out.print("Enter your new bid: ");
                auctioneer.acceptBid(userInput.nextDouble());
                displayHighestBid();
            } else {
                System.out.println("Item has been sold at: $" + gethighestBid());
                itemSold = true;
            }
        }
    }

    public void setAuctioneer(Auctioneer auctioneer) { this.auctioneer = auctioneer; }

    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    private void displayHighestBid() {
        System.out.println("The current highest bid is at: " + gethighestBid());
    }

    private double gethighestBid() {
        double max = 0.0;
        for (Bidder b : bidders) {
            if (max < b.getPersonalBid()) {
                max = b.getPersonalBid();
            }
        }
        if (max == 0) {
            return auctioneer.getCurrentBid();
        } else {
            return max;
        }
    }

    private void populateAuctionHouse() {
        auctioneer = new Auctioneer("John Smith");
        addBidder(new Bidder("Anthony Estey", 100.00));
        addBidder(new Bidder("Ian Cavers", 55.00));
        addBidder(new Bidder("Elisa Baniassad", 65.00));
        addBidder(new Bidder("James Yoo", 5.00));
        addBidder(new Bidder("Amy Zhu", 5.50));
        addBidder(new Bidder("James Xiao", 8.49));
        for (Bidder bidder : bidders) {
            auctioneer.addObserver(bidder);
        }
    }
}
