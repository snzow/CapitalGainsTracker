package StockLedger;

import Deque.DequeInterface;
import Deque.EmptyQueueException;
import Deque.LinkedDeque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        StockLedger ledger = new StockLedger();
        System.out.println("Welcome to Aodhan's Stock Ledger");
        Scanner kb = new Scanner(System.in);
        System.out.println("Press 1 for class test, press 2 for menu functionality");
        int input = kb.nextInt();
        if (input == 1){
            ledger.buy("AAPL",20,45);
            ledger.buy("AAPL",20,75);
            ledger.buy("MSFT",20,95);
            ledger.displayLedger();
            ledger.sell("AAPL",30,65);
            ledger.displayLedger();
            ledger.sell("AAPL",10,65);
            ledger.displayLedger();
            ledger.buy("AAPL",100,20);
            ledger.buy("AAPL",20,24);
            ledger.buy("TSLA",200,36);
            ledger.displayLedger();
            ledger.sell("AAPL",10,65);
            ledger.displayLedger();
            ledger.sell("TSLA",150,30);
            ledger.displayLedger();
            ledger.buy("MSFT",5,60);
            ledger.buy("MSFT",5,70);
            ledger.displayLedger();
            ledger.sell("MSFT",4,30);
            ledger.displayLedger();
            ledger.sell("MSFT",2,30);
            ledger.displayLedger();
        }
        else {
            while (true) {
                printMenu();
                input = kb.nextInt();
                if (input == 1) {
                    System.out.println("Enter Stock Symbol: ");
                    String stockSymbol = kb.next();
                    System.out.println("Enter Number of Shares to buy: ");
                    int shares = kb.nextInt();
                    System.out.println("Enter Price Purchased for: ");
                    double cost = kb.nextDouble();
                    ledger.buy(stockSymbol, shares, cost);
                } else if (input == 2) {
                    System.out.println("Enter Stock Symbol: ");
                    String stockSymbol = kb.next();
                    System.out.println("Enter Number of Shares to sell: ");
                    int shares = kb.nextInt();
                    System.out.println("Enter Price sold for: ");
                    double cost = kb.nextDouble();
                    ledger.sell(stockSymbol, shares, cost);
                } else if (input == 3) {
                    ledger.displayLedger();
                } else {
                    break;
                }
            }
        }

    }

    /**
     * Prints a menu of options a user can select from
     */
    public static void printMenu(){
        System.out.println("------------------------");
        System.out.println("Menu:");
        System.out.println("1. Buy Shares");
        System.out.println("2. Sell Shares");
        System.out.println("3. View Ledger");
        System.out.println("4. Quit");
        System.out.println("------------------------");
    }


}