package StockLedger;

import Deque.EmptyQueueException;
import Deque.LinkedDeque;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.ArrayList;

public class StockLedger implements StockLedgerInterface{
    ArrayList<LedgerEntry> entries;
    double totalProfit;

    /**
     * {@inheritDoc}
     */
    public StockLedger(){
        entries = new ArrayList<LedgerEntry>();
    }

    public void displayLedger(){
        System.out.println("---- Stock Ledger ----");
        for(LedgerEntry i : entries){
            i.displayEntry(i.symbol);
        }
        NumberFormat formatted = NumberFormat.getCurrencyInstance();
        System.out.println(" ");
        System.out.print("Total Profit: ");
        System.out.println(formatted.format(totalProfit));
    }
    public void buy(String stockSymbol, int sharesBought, double pricePerShare){
        double cost = sharesBought * pricePerShare;
        if (contains(stockSymbol)){
            getEntry(stockSymbol).addShares(stockSymbol,sharesBought,pricePerShare);
        }
        else{
            LedgerEntry temp = new LedgerEntry(stockSymbol,sharesBought,pricePerShare);
            entries.add(temp);
        }
    }

    public double sell(String stockSymbol, int sharesSold, double pricePerShare) throws EmptyQueueException {
        double q = getEntry(stockSymbol).sellShares(stockSymbol,sharesSold,pricePerShare);
        totalProfit += q;
        return q;


    }
    public boolean contains(String stockSymbol){
        return (getEntry(stockSymbol) != null);
    }

    public LedgerEntry getEntry(String stockSymbol){
        for(LedgerEntry entry : entries){
            if(entry.getSymbol().equals(stockSymbol)){
                return entry;
            }
        }
        return null;
    }

}
