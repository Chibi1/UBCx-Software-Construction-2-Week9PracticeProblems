package observer;

import java.util.LinkedList;
import java.util.List;

public class Subject {
    private List<BidderObserver> bidders;

    public Subject() {
        bidders = new LinkedList<>();
    }

    //getters
    public List<BidderObserver> getBidders() { return bidders; }

    public void addObserver(BidderObserver bidderObserver) {
        if (!bidders.contains(bidderObserver)) {
            bidders.add(bidderObserver);
        }
    }

    public void notifyObservers(Subject subject, double bid) {
        for (BidderObserver bidder : bidders) {
            bidder.update(subject, bid);
        }
    }
}
