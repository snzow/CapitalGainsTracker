package StockLedger;

import Deque.EmptyQueueException;

import java.util.ArrayList;

public class StockLedger implements StockLedgerInterface{
    ArrayList<LedgerEntry> entries;

    public StockLedger(){
        entries = new ArrayList<LedgerEntry>();
    }

    public void displayLedger(){
        System.out.println("---- Stock Ledger ----");
        for(LedgerEntry i : entries){
            i.displayEntry(i.symbol);
        }
    }
    public void buy(String stockSymbol, int sharesBought, double pricePerShare){
        if (contains(stockSymbol)){
            getEntry(stockSymbol).addShares(stockSymbol,sharesBought,pricePerShare);
        }
        else{
            LedgerEntry temp = new LedgerEntry(stockSymbol,sharesBought,pricePerShare);
            entries.add(temp);
            return;
        }

    }

    public double sell(String stockSymbol, int sharesSold, double pricePerShare) throws EmptyQueueException {
        return getEntry(stockSymbol).sellShares(stockSymbol,sharesSold,pricePerShare);
    }
    public boolean contains(String stockSymbol){
        if (getEntry(stockSymbol) != null){
            return true;
        }
        return false;
    }

    public LedgerEntry getEntry(String stockSymbol){
        for(LedgerEntry entry : entries){
            if (entry.symbol == stockSymbol){
                return entry;
            }
        }
        return null;
    }

}
