package uy.edu.um.prog2.adt.bst;

public interface MyBinarySearchTree<K,T> {

        public T find(K key);

        public void insert(K key, T data);

        public void delete(K key);
    }



