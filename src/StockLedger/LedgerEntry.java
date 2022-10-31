package StockLedger;

import Deque.EmptyQueueException;
import Deque.LinkedDeque;

import java.util.Iterator;

public class LedgerEntry {
    String symbol;

    LinkedDeque<StockPurchase> purchases;

    public LedgerEntry(String s, int numBought,double price){
        symbol = s;
        purchases = new LinkedDeque<StockPurchase>();
        for (int i = 0; i <= numBought; i++){
            StockPurchase temp = new StockPurchase(s,price);
            purchases.addToFront(temp);
        }
    }

    /**
     * Tallies and displays how many shares of the specified stock you own, and at what price they were purchased
     * Runs in O(N) time
     * @param StockSymbol the stock to display
     */
    public void displayEntry(String StockSymbol){

        double currPrice = 0;
        int numShares = 0;
        Boolean reset = false;
        if(purchases.getFront() == null){
            return;
        }
        System.out.print(purchases.getFront().getSymbol() + ": ");

        Iterator<StockPurchase> dequeIterator = purchases.getIterator();
        while (dequeIterator.hasNext()){
            double cost = dequeIterator.next().getCost();
            if (cost != currPrice){
                 if(currPrice != 0){
                     System.out.print(numShares + " shares), ");
                     reset = true;
                 }
                 numShares = 0;
                 if (reset){
                     numShares = -1;
                     reset = false;
                 }
                 currPrice = cost;
                 System.out.print(cost + " (");


             }
             numShares++;

         }
        System.out.println(numShares + " shares)");
    }

    /**
     * Takes the shares that have been purchased and adds them to LinkedDeque associated with that stock
     * @param s the symbol of the stock that was purchased
     * @param numBought the number of shares that was purchased
     * @param price the price at which the shares were purchased
     */
    public void addShares(String s, int numBought, double price){
        for (int i = 0; i <= numBought; i++){
            StockPurchase temp = new StockPurchase(s,price);
            purchases.addToFront(temp);
        }
    }

    /**
     * Sells the specified number of shares of symbol s at the specified price
     * @param s the specified number of shares
     * @param numSold the number of shares sold
     * @param price the price at which they were sold
     * @return the net profit of the sale
     * @throws EmptyQueueException can throw an empty queue exception if the deque is empty
     */
    public double sellShares(String s, int numSold, double price) throws EmptyQueueException {
        double profit = 0;
        for (int i = 0; i <= numSold; i++) {
            StockPurchase temp = purchases.removeBack();
            profit += price - temp.getCost();
        }
        return profit;
    }

    /**
     * returns the symbol of the LedgerEntry
     * @return the stock symbol of the ledger entry
     */
    public String getSymbol(){
        return symbol;
    }


}
