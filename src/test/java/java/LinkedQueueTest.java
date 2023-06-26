package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.exceptions.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.Queue;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    @Test
    void enqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(89);
        assertEquals(45, queue.peek());
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(89);
        assertEquals(45, queue.dequeue());
        assertEquals(23, queue.dequeue());
        assertEquals(89, queue.dequeue());
        assertThrows(EmptyQueueException.class, queue::dequeue);
    }

    @Test
    void isEmpty() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(89);
        assertFalse(queue.isEmpty());
    }


    @Test
    void getSize() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(89);
        assertEquals(3, queue.getSize());
    }

    @Test
    void peek() {
        Queue<Integer> queue = new Queue<>();
        assertThrows(EmptyQueueException.class, queue::peek);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(89);
        assertEquals(45, queue.peek());
    }
}