package StockLedger;

import Deque.EmptyQueueException;
import Deque.LinkedDeque;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

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

    public void displayEntry(String StockSymbol){

        double currPrice = 0;
        int numShares = 0;
        Boolean reset = false;
        if(purchases.getFront() == null){
            return;
        }
        System.out.print(purchases.getFront().getSymbol() + ": ");
        for(StockPurchase i : purchases){
             if (i.getCost() != currPrice){
                 if(currPrice != 0){
                     System.out.print(numShares + " shares), ");
                     reset = true;
                 }
                 numShares = 0;
                 if (reset){
                     numShares = -1;
                     reset = false;
                 }
                 currPrice = i.getCost();
                 System.out.print(i.getCost() + " (");


             }
             numShares++;

         }
        System.out.println(numShares + " shares)");
    }

    public void addShares(String s, int numBought, double price){
        for (int i = 0; i <= numBought; i++){
            StockPurchase temp = new StockPurchase(s,price);
            purchases.addToFront(temp);
        }
    }

    public double sellShares(String s, int numSold, double price) throws EmptyQueueException {
        double profit = 0;
        for (int i = 0; i <= numSold; i++) {
            StockPurchase temp = purchases.removeBack();
            profit += price - temp.getCost();
        }
        return profit;
    }




}
