package uy.edu.um.prog2.adt.heap;

public interface MyHeap<K,T> {

    public void insert(K key,T data);

    public HeapNode<K,T> delete();

    public int size();

    String toString();
}
