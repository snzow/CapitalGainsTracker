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
        while(true){
            System.out.println("------------------------");
            System.out.println("Menu:");
            System.out.println("1. Buy Shares");
            System.out.println("2. Sell Shares");
            System.out.println("3. View Ledger");
            System.out.println("4. Quit");
            System.out.println("------------------------");
            int input = kb.nextInt();
            if (input == 1){
                System.out.println("Enter Stock Symbol: ");
                String stockSymbol = kb.next();
                System.out.println("Enter Number of Shares to buy: ");
                int shares = kb.nextInt();
                System.out.println("Enter Price Purchased for: ");
                double cost = kb.nextDouble();
                ledger.buy(stockSymbol,shares,cost);
            }
            else if(input == 2){
                System.out.println("Enter Stock Symbol: ");
                String stockSymbol = kb.next();
                System.out.println("Enter Number of Shares to sell: ");
                int shares = kb.nextInt();
                System.out.println("Enter Price sold for: ");
                double cost = kb.nextDouble();
                ledger.sell(stockSymbol,shares,cost);
            }
            else if(input == 3){
                ledger.displayLedger();
            }
            else{
                break;
            }
        }
    }


}