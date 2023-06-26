package uy.edu.um.prog2.adt.heap;


public class Heap<K extends Comparable<K>, T> implements MyHeap<K, T> {

    public HeapNode<K, T>[] values;

    private int indexNextElement = 0;

    private int initialSize;

    public boolean isHeapMax; //decido si es heapmax o heapmin

    public Heap(boolean isHeapMax) {
        this.values = new HeapNode[20];
        this.isHeapMax = isHeapMax;
        this.initialSize=20;
    }

    public Heap(boolean isHeapMax, int size) {
        this.values = new HeapNode[size];
        this.isHeapMax = isHeapMax;
        this.initialSize = size;
    }

    @Override
    public void insert(K key, T data) {
        if((float)indexNextElement>=0.8*initialSize){
            this.reSize();
        }
        HeapNode<K, T> temp = new HeapNode<K, T>(key, data);
        values[indexNextElement] = temp;
        int elementIndex = indexNextElement;
        indexNextElement++;

        int fatherIndex = getFatherIndex(elementIndex);
        int comparison = -1;
        if (this.isHeapMax) {
            comparison = 1;
        }
        while (key.compareTo(this.values[fatherIndex].getKey()) == comparison &&
                elementIndex != 0) {
            // hacer permutacion
            // bajo el padre a donde esta el hijo
            values[elementIndex] = this.values[fatherIndex];
            // subo al hijo
            values[fatherIndex] = temp;
            elementIndex = fatherIndex;
            fatherIndex = getFatherIndex(elementIndex);
        }
    }


    protected int getFatherIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int fatherIndex) {
        int result = 2 * fatherIndex + 1;
        if (values[result] == null) {
            result = -1;
        }
        return result;
    }

    public int getRightChildIndex(int fatherIndex) {
        int result = 2 * fatherIndex + 2;
        if (values[result] == null) {
            result = -1;
        }
        return result;
    }

    @Override
    public HeapNode<K, T> delete() {
        int elementIndex = 0;
        HeapNode<K, T> result = values[0];
        if (result == null) {
            return result;
        }
        indexNextElement--;
        HeapNode<K, T> temp = values[indexNextElement];
        values[indexNextElement] = null;
        values[elementIndex] = temp;
        int leftChildIndex = getLeftChildIndex(elementIndex);
        int rightChildIndex = getRightChildIndex(elementIndex);
        int comparison = 1;
        if (this.isHeapMax) {
            comparison = -1;
        }
        while (rightChildIndex != -1) {
            if (temp.getKey().compareTo(this.values[leftChildIndex].getKey()) == comparison ||
                    temp.getKey().compareTo(this.values[rightChildIndex].getKey()) == comparison) {

                if (this.values[leftChildIndex].getKey().compareTo(this.values[rightChildIndex].getKey()) == -comparison) {
                    values[elementIndex] = this.values[leftChildIndex];
                    values[leftChildIndex] = temp;
                    elementIndex = leftChildIndex;
                } else {
                    values[elementIndex] = this.values[rightChildIndex];
                    values[rightChildIndex] = temp;
                    elementIndex = rightChildIndex;
                }
                leftChildIndex = getLeftChildIndex(elementIndex);
                rightChildIndex = getRightChildIndex(elementIndex);
            } else {
                break;
            }
        }
        if (leftChildIndex != -1) {
            if (temp.getKey().compareTo(this.values[leftChildIndex].getKey()) == comparison) {
                values[elementIndex] = this.values[leftChildIndex];
                values[leftChildIndex] = temp;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return indexNextElement;
    }

    public void reSize() {
        HeapNode<K, T>[] oldValues = values;
        values = new HeapNode[oldValues.length*2];
        indexNextElement = 0;
        for (HeapNode<K, T> heapNode : oldValues) {
            if (heapNode != null) {
                insert(heapNode.getKey(), heapNode.getData());
            }
        }
    }

    @Override
    public String toString() {
        String heapString = "";
        int level = 0;
        int currentPosition = 0;
        while(currentPosition != size()){ //mientras no llegue al final del heap
            heapString += values[currentPosition].toString() + " "; // agrego el elemento actual
            if((Math.pow(2,level + 1)) - 2 == currentPosition){ //si estoy en el último elemento de la línea
                level++; //aumento el nivel
                heapString += "\n"; //agrego un salto de línea

            }
            currentPosition++;

        }
        return heapString;
    }

}
