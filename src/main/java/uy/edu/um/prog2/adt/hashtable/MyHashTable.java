package uy.edu.um.prog2.adt.hashtable;

public interface MyHashTable<K, T>{

    void put(K key, T value);
    boolean contains(K key);
    void remove(K key);
    T get(K key);
    int getLoad(); // me devuelve el porcentaje de ocupación de la tabla

    void resize();
    int size();

}
