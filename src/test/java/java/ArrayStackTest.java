package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.stack.ArrayStack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void push() {
        ArrayStack<Integer> stack = new ArrayStack<>(10, Integer.class);
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertEquals(97, stack.top());
    }

    @Test
    void pop() {
        ArrayStack<Integer> stack = new ArrayStack<>(10, Integer.class);
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertEquals(97, stack.top());
        stack.pop();
        assertEquals(87, stack.top());
        stack.pop();
        assertEquals(78, stack.top());
        stack.pop();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void top() {
        ArrayStack<Integer> stack = new ArrayStack<>(10, Integer.class);
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertEquals(97, stack.top());
        stack.makeEmpty();
        assertThrows(EmptyStackException.class, stack::top);
    }

    @Test
    void isEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<>(10, Integer.class);
        assertTrue(stack.isEmpty());
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertFalse(stack.isEmpty());
    }

    @Test
    void makeEmpty() {
        ArrayStack<Integer> stack = new ArrayStack<>(10, Integer.class);
        stack.push(78);
        stack.push(87);
        stack.push(97);
        stack.makeEmpty();
        stack.makeEmpty();
        assertThrows(EmptyStackException.class, stack::pop);
    }
}