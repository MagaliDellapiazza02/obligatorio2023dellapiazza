package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.stack.LinkedStack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    void push() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertEquals(97, stack.top());
    }

    @Test
    void pop() {
        LinkedStack<Integer> stack = new LinkedStack<>();
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
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertEquals(97, stack.top());
        stack.makeEmpty();
        assertThrows(EmptyStackException.class, stack::top);
    }

    @Test
    void isEmpty() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertFalse(stack.isEmpty());
    }

    @Test
    void makeEmpty() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(78);
        stack.push(87);
        stack.push(97);
        stack.makeEmpty();
        stack.makeEmpty();
        assertThrows(EmptyStackException.class, stack::pop);
    }


    @Test
    void getSize() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(78);
        stack.push(87);
        stack.push(97);
        assertEquals(3, stack.size());
    }
}