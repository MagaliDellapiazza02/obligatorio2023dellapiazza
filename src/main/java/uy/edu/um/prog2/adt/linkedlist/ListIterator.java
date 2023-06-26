package uy.edu.um.prog2.adt.linkedlist;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
    Nodo<T> current;

    public ListIterator(LinkedList<T> list) {
        this.current = list.getPrimerValor();
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    } //si el current es null, no hay mas elementos

    @Override
    public T next() {
        T data= current.getValor();
        current=current.getNext();
        return data;
    }
}
