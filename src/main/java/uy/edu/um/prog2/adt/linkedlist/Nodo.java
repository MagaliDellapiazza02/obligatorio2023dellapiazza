package uy.edu.um.prog2.adt.linkedlist;

public class Nodo<T> {

    public T valor;
    public Nodo<T> next;
    public int position;

    public Nodo(T valor) {
        this.valor = valor;
        this.next = null;
    }

    public Nodo(T valor, Nodo<T> next) {
        this.valor = valor;
        this.next = next;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "valor=" + valor +
                ", next=" + next +
                ", position=" + position +
                '}';
    }
}
