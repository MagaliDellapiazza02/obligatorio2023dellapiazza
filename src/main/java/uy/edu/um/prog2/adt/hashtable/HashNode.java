package uy.edu.um.prog2.adt.hashtable;

@SuppressWarnings("all")
public class HashNode<K, T> {

    private K key;
    private T value;
    private boolean isDeleted;


    public HashNode(K key, T value) {
        this.key = key;
        this.value = value;
        this.isDeleted=false;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }


}
