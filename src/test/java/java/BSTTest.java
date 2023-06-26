package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.bst.MyBST;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    @Test
    void testInsert() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        assertEquals("root", sut.find(20));
    }

    @Test
    void testInsert1() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        assertEquals("b", sut.find(22));
    }

    @Test
    void testInsert2() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        sut.insert(16, "c");
        sut.insert(24, "d");
        assertEquals("a", sut.find(18));
        assertEquals("d", sut.find(24));
    }

    @Test
    void testInsert3() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        sut.insert(22, "b");
        assertEquals(2, sut.getCount(22));
    }

    @Test
    void testDelete() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        sut.delete(20);
        assertNull(sut.find(20));
    }

    @Test
    void testDelete1() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        sut.insert(16, "c");
        sut.insert(24, "d");
        sut.insert(19, "e");
        sut.insert(21, "f");
        sut.delete(16);
        assertNull( sut.find(16));
    }

    @Test
    void testDelete2() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        sut.insert(16, "c");
        sut.insert(24, "d");
        sut.insert(19, "e");
        sut.insert(21, "f");
        sut.delete(16);
        assertNull(sut.find(16));
        sut.delete(18);
        assertNull(sut.find(18));
        assertEquals("e", sut.getRoot().getLeftChild().getData());
    }

    @Test
    void testDelete3() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(23, "b");
        sut.insert(16, "c");
        sut.insert(24, "d");
        sut.insert(19, "e");
        sut.insert(21, "f");
        sut.insert(22, "g");
        sut.delete(23);
        assertNull(sut.find(23));
        assertEquals("g", sut.getRoot().getRightChild().getData());
    }

    @Test
    void testDelete4() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(18, "a");
        sut.insert(22, "b");
        sut.insert(16, "c");
        sut.insert(24, "d");
        sut.insert(19, "e");
        sut.insert(21, "f");
        sut.delete(24);
        assertNull(sut.find(24));
    }

    @Test
    void testDelete5() {
        MyBST<Integer, String> sut = new MyBST<>();
        sut.insert(20, "root");
        sut.insert(10, "a");
        sut.insert(30, "b");
        sut.insert(5, "c");
        sut.insert(35, "d");
        sut.insert(15, "e");
        sut.insert(25, "f");
        sut.delete(5);
        sut.insert(13,"g");
        sut.insert(14,"h");
        sut.delete(10);
        assertNull(sut.find(10));
        assertNull(sut.find(5));
        assertEquals("g",sut.getRoot().getLeftChild().getData());
    }

}