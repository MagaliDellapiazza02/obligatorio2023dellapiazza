package uy.edu.um.prog2.adt.bst;


public class MyBST<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {

    private NodeBST<K, T> root;

    @Override
    public T find(K key) {
        NodeBST<K,T> temp=null;
        T data = null;
        if (root != null) {
            temp = find(key, this.root);
        }
        if(temp!=null){
            data=temp.getData();
        }
        return data;
    }

    public NodeBST<K, T> find(K key, NodeBST<K, T> root) {
        NodeBST<K, T> result = null;
        if (root.getKey().compareTo(key) == 0) {
            result = root;

        } else if (root.getKey().compareTo(key) > 0) {
            if (root.getLeftChild() != null) {
                result = find(key, root.getLeftChild());
            }
        } else {
            if (root.getRightChild() != null) {
                result = find(key, root.getRightChild());
            }
        }
        return result;
    }

    @Override
    public void insert(K key, T data) {
        if (this.root == null) {
            root = new NodeBST<K, T>(key, data);
        } else {
            NodeBST<K, T> temp = find(key, this.root);

            if (temp != null) {
                temp.setCount(temp.getCount() + 1);
            } else {
                this.root = insert(key, data, this.root);
            }
        }
    }

    public NodeBST<K, T> insert(K key, T data, NodeBST<K, T> root) {
        if (root.getKey().compareTo(key) > 0) {
            if (root.getLeftChild() != null) {
                root.setLeftChild(insert(key, data, root.getLeftChild()));
            } else {
                root.setLeftChild(new NodeBST<K, T>(key, data));
            }
        } else if (root.getKey().compareTo(key) < 0) {
            if (root.getRightChild() != null) {
                root.setRightChild(insert(key, data, root.getRightChild()));
            } else {
                root.setRightChild(new NodeBST<K, T>(key, data));
            }
        }
        return root;
    }

    @Override
    public void delete(K key) {
        root = delete(key, this.root);
    }

    public NodeBST<K, T> delete(K key, NodeBST<K, T> root) {
        NodeBST<K, T> result = root;
        if (root == null) {
            // no hacer nada
        } else if (root.getKey().compareTo(key) > 0) {
            root.setLeftChild(delete(key, root.getLeftChild()));
        } else if (root.getKey().compareTo(key) < 0) {
            root.setRightChild(delete(key, root.getRightChild()));
        } else {
                NodeBST<K, T> temp;
                if (root.getLeftChild() != null) {
                    temp = getMax(root.getLeftChild());
                    root.setData(temp.getData());
                    root.setKey(temp.getKey());
                    root.setLeftChild(delete(temp.getKey(), root.getLeftChild()));
                } else if(root.getRightChild() !=null){
                    temp = getMin(root.getRightChild());
                    root.setData(temp.getData());
                    root.setKey(temp.getKey());
                    root.setRightChild(delete(temp.getKey(), root.getRightChild()));
                }
                else{
                    result=null;
                }
            }
        return result;
    }

    private NodeBST<K,T> getMin(NodeBST<K,T> root) {
        NodeBST<K,T> result = null;

        if (root.getLeftChild() == null) {
            result = root;
        } else {
            result = getMin(root.getLeftChild());
        }

        return result;
    }
    private NodeBST<K,T> getMax(NodeBST<K,T> root) {
        NodeBST<K,T> result = null;

        if (root.getRightChild() == null) {
            result = root;
        } else {
            result = getMax(root.getRightChild());
        }

        return result;
    }
    public int getCount(K key){
        NodeBST<K,T> temp=find(key,root);
        int result=0;
        if(temp!=null){
            result=temp.getCount();
        }
        return result;
    }

    public NodeBST<K, T> getRoot() {
        return root;
    }

}
