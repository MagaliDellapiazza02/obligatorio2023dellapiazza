package uy.edu.um.prog2.adt.linkedlist;

import uy.edu.um.prog2.adt.exceptions.IllegalIndexException;

public interface MyLinkedList<T> extends Iterable<T>{
    public void add(T value);

    public int size();

    public T get(int position);

    public void addFirst(T value);

    public void addByIndex(T obj, int index) throws IllegalIndexException;

    public boolean contains(T elemento);

}
