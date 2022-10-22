package StockLedger;

import Deque.DequeInterface;
import Deque.EmptyQueueException;
import Deque.LinkedDeque;

public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        LinkedDeque<Integer> test = new LinkedDeque<>();
        test.addToBack(4);
        test.addToFront(3);
        test.addToFront(5);
        test.addToFront(11);
        test.addToFront(8);
        test.addToFront(1);
        System.out.println(test.getFront());
        System.out.println(test.removeFront());
        System.out.println(test.getBack());
        System.out.println(test.removeBack());
    }
}