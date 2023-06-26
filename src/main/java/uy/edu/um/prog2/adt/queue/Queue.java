package uy.edu.um.prog2.adt.queue;

import uy.edu.um.prog2.adt.exceptions.EmptyQueueException;

public class Queue<T> implements MyQueue<T> {

    private Node<T> first;
    private int size;

    public Queue() {
    }

    @Override
    public void enqueue(T element) {
        Node<T> node = new Node<>(element);
        if (first == null){
            first = node;
        } else {
            node = first;
            while (node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(new Node<>(element));
        }
        size++;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (first == null){
            throw new EmptyQueueException();
        } else {
            T value = first.getValue();
            this.first = first.getNext();
            size--;
            return value;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public T peek() throws EmptyQueueException {
        if (first == null) {
            throw new EmptyQueueException();
        }
        return first.getValue();
    }

    public int getSize() {
        return size;
    }
}
