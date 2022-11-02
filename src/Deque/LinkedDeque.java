package Deque;

import java.util.Iterator;

public class LinkedDeque<T> implements DequeInterface<T>{

    /**
     * {@inheritDoc}
     */
    DLNode front;
    DLNode back;

    private class DLNode{
        private T data;
        private DLNode next;
        private DLNode prev;

        private DLNode(T d){
            data = d;
            next = null;
            prev = null;
        }

        private T getData(){
            return data;
        }

        private void setData(T d){
            data = d;
        }

        private DLNode getNextNode(){
            return next;
        }

        private void setNextNode(DLNode n){
            next = n;
        }

        private DLNode getPreviousNode(){
            return prev;
        }

        private void setPreviousNode(DLNode n){
            prev = n;
        }
    }

    public void addToFront(T newEntry) {
        if (isEmpty()){
            DLNode temp = new DLNode(newEntry);
            front = temp;
            back = temp;
        }
        else{
            DLNode temp = new DLNode(newEntry);
            front.setPreviousNode(temp);
            temp.setNextNode(front);
            front = temp;
        }
    }


    public void addToBack(T newEntry) {
        if (isEmpty()){
            DLNode temp = new DLNode(newEntry);
            front = temp;
            back = temp;
        }
        else{
            DLNode temp = new DLNode(newEntry);
            back.setNextNode(temp);
            temp.setPreviousNode(back);
            back = temp;
        }
    }

    public T removeFront() throws EmptyQueueException {
        if( isEmpty()){
            throw new EmptyQueueException();
        }
        T dataToReturn = front.getData();
        if( front.getNextNode() == null){
            front = null;
            back = null;
        }
        else{
            front.getNextNode().setPreviousNode(null);
            front = front.getNextNode();
        }
        return dataToReturn;
    }


    public T removeBack() throws EmptyQueueException {

        if( isEmpty()){
            throw new EmptyQueueException();
        }

        T dataToReturn = back.getData();

        if (back.getPreviousNode() == null){
            front = null;
            back = null;
        }
        else{
            back.getPreviousNode().setNextNode(null);
            back = back.getPreviousNode();

        }
        return dataToReturn;
    }


    public boolean isEmpty() {
        return ( front == null && back == null);
    }


    public T getFront() {
        if( isEmpty()){
            return null;
        }
        return front.getData();
    }


    public T getBack() {
        if( isEmpty()){
            return null;
        }
        return back.getData();
    }


    public void clear() {
        front = null;
        back = null;
    }

    public IteratorForLinkedList<T> iterator() {
        return getIterator();
    }


    public IteratorForLinkedList<T> getIterator() {
        return new IteratorForLinkedList<>();
    }

    private class IteratorForLinkedList<T> implements Iterator<T> {

        DLNode front;
        DLNode back;
        DLNode current;

        public IteratorForLinkedList(){
            front = LinkedDeque.this.front;
            back = LinkedDeque.this.back;
            current = front;

        }

        @Override
        public boolean hasNext() {
            return (current.getNextNode() != null);
        }

        public void resetToBack(){
            current = back;
        }

        public void resetToFront(){
            current = front;
        }

        @Override
        public T next() {
            current = current.getNextNode();
            return (T) current.getData();
        }

    }
}
