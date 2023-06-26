package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.linkedlist.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void add() {
        LinkedList<Integer> lista= new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        assertEquals(-4,lista.get(2));
        assertNull(lista.get(5));
    }

    @Test
    public void get() {
        LinkedList<String> lista=new LinkedList<String>();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        assertEquals("d",lista.get(3));
        assertNull(lista.get(5));
    }

    @Test
    public void size() {
        LinkedList<String> lista=new LinkedList<String>();
        assertEquals(0,lista.size());
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        lista.add("e");
        assertEquals(5,lista.size());
        lista.add("f");
        assertEquals(6,lista.size());
    }

    @Test
    public void remove() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        lista.remove(0);
        assertEquals(2,lista.get(0));
        assertEquals(-4,lista.get(1));
        lista.remove(lista.size()-1);
        assertEquals(7,lista.get(lista.size()-1));
    }
    @Test
    public void remove1() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.remove(1);
        assertEquals(1,lista.get(0));
        assertNull(lista.get(1));
        assertEquals(1,lista.size());
    }
    @Test
    public void remove2() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        lista.remove(5);
        assertEquals(22,lista.get(lista.size()-1));
    }
    @Test
    public void remove3() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        lista.add(56);
        lista.add(77);
        lista.remove(4);
        assertEquals(56,lista.get(4));
    }

    @Test
    public void contains() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        assertTrue(lista.contains(7));
        assertTrue(lista.contains(22));
        assertTrue(lista.contains(1));
    }
    @Test
    public void contains1() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        assertTrue(lista.contains(7));
        assertTrue(lista.contains(22));
        assertTrue(lista.contains(1));
        assertFalse(lista.contains(0));
    }

    @Test
    public void addFirst() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        lista.add(-22);
        assertEquals(-22,lista.get(0));
    }

    @Test
    public void addLast() {
        LinkedList<Integer> lista=new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(-4);
        lista.add(7);
        lista.add(22);
        lista.addLast(-22);
        assertEquals(-22,lista.get(lista.size()-1));
    }

    @Test
    public void append() {
        LinkedList<Integer> lista0=new LinkedList<Integer>();
        lista0.add(1);
        lista0.add(2);
        lista0.add(-4);
        lista0.add(7);
        lista0.add(22);
        LinkedList<Integer> lista1=new LinkedList<Integer>();
        lista1.add(-1);
        lista1.add(-2);
        LinkedList<Integer> l= lista0.append(lista1);
        assertEquals(7,l.size());
        assertEquals(-4,l.get(2));
        assertEquals(-1,l.get(l.size()-2));
    }
}