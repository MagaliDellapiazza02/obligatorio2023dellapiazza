package uy.edu.um.prog2.adt.linkedlist;

import uy.edu.um.prog2.adt.exceptions.IllegalIndexException;

import java.util.Iterator;

public class LinkedList<T> implements MyLinkedList<T> {
    public Nodo<T> first;

    public int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void addFirst(T value) {
        Nodo<T> temp = first;
        first = new Nodo<>(value, temp);
        this.size++;
    }

    @Override
    public void add(T value){
        if (size == 0) {
            first = new Nodo<>(value);
            size++;
        } else {
            Nodo<T> temp = first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            size++;
            temp.setNext(new Nodo<>(value, null));
        }
    }
    @Override
    public void addByIndex(T obj, int index) throws IllegalIndexException {
        Nodo<T> nuevo = new Nodo<T>(obj);
        if (index == 0) {
            add(obj); //agrega primero
        } else if (index == size - 1) {
            add(obj); //agrega a lo ultimo
            if (index < size()) {
                int i = 0;
                Nodo<T> aux = first;
                while (i < index - 1) {
                    i++;
                    aux = aux.getNext();
                }
                nuevo.setNext(aux.getNext());
                aux.setNext(nuevo);
            } else {
                throw new IllegalIndexException("El índice es mayor al largo de la lista");
            }
        }
    }

        @Override
        public T get(int position) {
            Nodo<T> temp = first;
            T result = null;
            if (position < this.size()) {
        for (int i = 0; i < position; i++) {
            temp = temp.getNext(); }
            if (temp != null) {
                result = temp.getValor();
            }
        }return result;
    }

            @Override
            public int size() {
                return this.size;
            }

            public void remove(int position) {
                Nodo<T> temp = first;
                Nodo<T> temp2 = null;

                if (position == 0) {
            first = first.getNext();
            this.size--;
        } else if (position == 1 && this.size == 2) {
            temp.setNext(null);
            this.size--;
        } else if (position < this.size) {
            for (int i = 0; i < (position - 1); i++) {
                temp = temp.getNext();
                temp2 = temp.getNext();
            }
            temp.setNext(temp2.getNext());
            this.size--;
        }
            }


    @Override
    public boolean contains(T elemento) {
        Nodo<T> temp = first;
        while (temp.getValor() != elemento) {
            temp = temp.getNext();
            if (temp == null) {
                return false;
            }
        }
        return true;
    }

    public void addLast(T value) {
        add(value);
    }

    public LinkedList<T> append(LinkedList<T> p) {
        LinkedList<T> l = new LinkedList<>();
        Nodo<T> temp = first;
        while (temp != null) {
            l.add(temp.getValor());
            temp = temp.getNext();
        }
        temp = p.first;
        while (temp != null) {
            l.add(temp.getValor());
            temp = temp.getNext();
        }
        return l;
    }

    public Nodo<T> getPrimerValor() {
        return first;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

    public void print() {
        Nodo<T> temp = first;
        while (temp != null) {
            System.out.print(temp.getValor());
            temp = temp.getNext();
            if (temp != null)
                System.out.print(" -> ");
        }
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "primerValor=" + first +
                ", count=" + this.size +
                '}';
    }
}
