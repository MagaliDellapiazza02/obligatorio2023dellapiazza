package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.heap.Heap;
import uy.edu.um.prog2.adt.heap.HeapNode;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest<K extends Comparable<K>, T> {
    @Test
    public void testInsert0() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true);
        heap.insert(1, "a");
        heap.insert(5, "b");
        heap.insert(9, "c");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testInsert1() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true);
        heap.insert(1, "a");
        heap.insert(5, "b");
        heap.insert(9, "c");
        heap.insert(11, "d");
        heap.insert(7, "e");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testInsert2() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true);
        heap.insert(1, "a");
        heap.insert(5, "b");
        heap.insert(9, "c");
        heap.insert(11, "d");
        heap.insert(7, "e");
        heap.insert(4, "f");
        heap.insert(3, "g");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testInsert3() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true);
        heap.insert(1, "a");
        heap.insert(5, "b");
        heap.insert(9, "c");
        heap.insert(11, "d");
        heap.insert(7, "e");
        heap.insert(4, "f");
        heap.insert(3, "g");
        heap.insert(20, "h");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testInsert4() {
        Heap<Integer, String> heap = new Heap<Integer, String>(false);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testInsert5() {
        Heap<Integer, String> heap = new Heap<Integer, String>(false);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testInsert6() {
        Heap<Integer, String> heap = new Heap<Integer, String>(false);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(10, "f");
        heap.insert(11, "g");
        heap.insert(-5, "h");
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testDelete() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(11, "f");
        heap.delete();
        assertTrue(isAHeap(heap));
    }

    @Test
    public void testDelete1() {
        Heap<Integer, String> heap = new Heap<Integer, String>(false, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(11, "f");
        heap.delete();
        assertTrue(isAHeap(heap));
    }
    @Test
    public void testDelete2() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(11, "f");
        heap.insert(22,"g");
        heap.insert(33,"h");
        heap.insert(17,"i");
        heap.delete();
        assertTrue(isAHeap(heap));
    }
    @Test
    public void testDelete3() {
        Heap<Integer, String> heap = new Heap<Integer, String>(false, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(11, "f");
        heap.insert(22,"g");
        heap.insert(33,"h");
        heap.insert(17,"i");
        heap.delete();
        assertTrue(isAHeap(heap));
    }
    @Test
    public void testDelete4() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(11, "f");
        heap.insert(22,"g");
        heap.insert(33,"h");
        heap.insert(17,"i");
        heap.delete();
        heap.delete();
        heap.insert(15,"j");
        heap.delete();
        assertTrue(isAHeap(heap));
    }
    @Test
    public void testDelete5(){
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(9, "b");
        heap.insert(1, "c");
        heap.delete();
    }
    @Test
    public void testDelete6(){
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.delete();
    }
    @Test
    public void testDelete7(){
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(20, "a");
        heap.insert(15, "b");
        heap.insert(10, "c");
        heap.insert(3,"d");
        heap.insert(4,"e");
        heap.insert(11,"f");
        heap.delete();
    }
    @Test
    public void testDelete8(){
        Heap<Integer, String> heap = new Heap<Integer, String>(false, 11);
        heap.insert(1, "a");
        heap.insert(2, "b");
        heap.insert(3, "c");
        heap.insert(4,"d");
        heap.insert(5,"e");
        heap.insert(6,"f");
        heap.insert(7,"d");
        heap.insert(8,"e");
        heap.insert(9,"f");
        heap.insert(10,"f");
        heap.insert(11,"g");
        heap.delete();
        assertTrue(isAHeap(heap));
    }


    @Test
    public void testSize() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.delete();
        assertEquals(4,heap.size());
    }

    @Test
    public void testSize2() {
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.delete();
        heap.delete();
        assertEquals(3, heap.size());
    }
    @Test
    public void testSize3(){
        Heap<Integer, String> heap = new Heap<Integer, String>(true, 10);
        heap.insert(5, "a");
        heap.insert(1, "b");
        heap.insert(9, "c");
        heap.insert(-2, "d");
        heap.insert(6, "e");
        heap.insert(11, "f");
        heap.insert(22,"g");
        heap.insert(33,"h");
        heap.insert(17,"i");
        heap.delete();
        heap.delete();
        heap.insert(15,"j");
        heap.delete();
        assertEquals(7,heap.size());
    }

    private boolean isAHeap(Heap<Integer,String> heap) {
        HeapNode<Integer, String>[] values = heap.values;
        boolean result = true;
        int fatherIndex = 0;
        int leftChildIndex = heap.getLeftChildIndex(fatherIndex);
        int rightChildIndex = heap.getRightChildIndex(fatherIndex);
        int comparison = 1;
        if (heap.isHeapMax) {
            comparison = -1;
        }
        while (rightChildIndex!=-1)
        {
            if(values[fatherIndex].getKey().compareTo(values[leftChildIndex].getKey()) == comparison &&
                    values[fatherIndex].getKey().compareTo(values[rightChildIndex].getKey()) == comparison){
                result=true;
            }
            fatherIndex++;
            leftChildIndex = heap.getLeftChildIndex(fatherIndex);
            rightChildIndex = heap.getRightChildIndex(fatherIndex);
        }
        return result;
    }
}