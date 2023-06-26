package uy.edu.um.prog2.adt.stack;
import java.util.EmptyStackException;

public class LinkedStack<T> implements MyStack<T>{

    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.size=0;
        this.top=null;
    }

    @Override
    public void push(T element) {
        Node<T> node = new Node<>(element);
        if (top != null) {
            node.setNext(top);
        }
        top = node;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        T value;
        if (top == null){
            throw new EmptyStackException();
        } else {
            value= top.getValue();
            top = top.getNext();
            size--;
        }
        return value;
    }

    @Override
    public T top() throws EmptyStackException {
        T value;
        if (top == null){
            throw new EmptyStackException();
        } else {
            value = top.getValue();
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void makeEmpty() {
        if (top != null){
            while (top.getNext() != null){
                top = top.getNext();
            }
            top = null;
        } else {
            System.out.println("Stack is empty.");
        }
    }

    @Override
    public int size() {
        return size;
    }

}
