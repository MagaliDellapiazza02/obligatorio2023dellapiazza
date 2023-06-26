package uy.edu.um.prog2.adt.bst;

public class NodeBST<K extends Comparable<K>, T> {
    private K key;

    private T data;

    private NodeBST<K, T> leftChild;

    private NodeBST<K, T> rightChild;

    private int count;

    public NodeBST(K key, T data) {
        this.key = key;
        this.data = data;
        this.count=1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeBST<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}
