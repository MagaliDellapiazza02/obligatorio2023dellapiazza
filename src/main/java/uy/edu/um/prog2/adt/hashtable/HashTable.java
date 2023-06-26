package uy.edu.um.prog2.adt.hashtable;

import uy.edu.um.prog2.adt.linkedlist.LinkedList;

import static java.lang.Math.abs;

public class HashTable<K, T> implements MyHashTable<K, T> {

    private int size;
    private int load;
    private static final double LOAD_FACTOR = 0.75;
    private HashNode<K, T>[] elements;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.elements = new HashNode[size];
        this.size = 0;
    }

    @Override
    public void put(K key, T value) {
        boolean is_put = false;
        int counter = 0;
        HashNode<K, T> hashNode = new HashNode<>(key, value);

        while(!is_put && counter < capacity()){
            int position=abs((key.hashCode() +counter) % capacity());
            if (elements[position] == null) {
                elements[position] = hashNode;
                is_put = true;
                load++;
            }
            else if(elements[position].getKey().equals(key)){
                return;
            }
            else{
                counter++;
            }
        }
        if (load >= (capacity()*LOAD_FACTOR)) {
            rehash(capacity() * 2);
        }

    }


    @SuppressWarnings("unchecked")
    private void rehash(int newSize){
        HashNode<K, T>[] oldElements = elements;
        elements = new HashNode[newSize];
        load = 0;
        for (HashNode<K, T> hashNode : oldElements) {
            if (hashNode != null) {
                put(hashNode.getKey(), hashNode.getValue());
            }
        }
    }

    private int capacity(){
        return elements.length;
    }

    @Override
    public boolean contains(K key) {
        int collision = 0;
        int position = abs((key.hashCode() + collision) % capacity());
        if (elements[position] != null) {
            if (elements[position].getKey().equals(key)) {
                return true;
            } else {
                for (int i = position; i < capacity(); i++) {
                    if (elements[i] != null) {
                        if (elements[i].getKey().equals(key))
                            return true;
                    }
                }
            }
        }return false;
    }

    public LinkedList<T> hashToLinkedList(){
        LinkedList<T> list = new LinkedList<>();

        for (HashNode<K, T> hashNode : elements) {
            if (hashNode != null) {
                list.add(hashNode.getValue());
            }
        }
        return list;
    }

    @Override
    public void remove(K key) {
        int collision = 0;
        int position = abs((key.hashCode() + collision) % capacity());
        int startPos = position;
        while (elements[position] != null) {
            if (elements[position].getKey().equals(key)){
                elements[position] = null;
                load--;
            }
            collision++;
            position = abs((key.hashCode() + collision) % capacity());
            if (position == startPos) break;
        }
        if (load == capacity() / 4 && capacity() / 2 != 0){
            rehash(capacity() / 2);
        }
    }

    @Override
    public T get(K key) {
        int collision = 0;
        int position = abs((key.hashCode() +collision) % capacity());
        int startPos  = position;
        while (elements[position] != null){
            if (elements[position].getKey().equals(key)){
                return elements[position].getValue();
            }
            collision++;
            position = abs((key.hashCode() + collision) % capacity());
            if (position == startPos) break;
        }
        return null;
    }

    public void resize(){
        HashTable<K,T> newHash = new HashTable<>(2 * size);
        for(int i = 0; i < size; i++){
            if (elements[i] != null) {
                newHash.put(elements[i].getKey(),elements[i].getValue());
            }
        }
        size *= 2;
        elements = newHash.getElements();
    }

    @Override
    public int getLoad() {
        return load;
    }

    public int getSize() {
        return size;
    }

    public HashNode<K, T>[] getElements() {
        return elements;
    }

    }



