package java;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.hashtable.HashTable;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void put() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(1234L, "Magalí");
        hashTable.put(4562L, "José");
        hashTable.put(4557L, "Miguel");
        hashTable.put(4567L, "Florencia");
        hashTable.put(4553L, "Renata");
        hashTable.put(1231L, "Carla");
        hashTable.put(1231L, "Agustina");
        hashTable.put(4566L, "Belén");
        hashTable.put(1235L, "Santiago");
        hashTable.put(4550L, "Martín");
        hashTable.put(4562L, "Germán");
        assertEquals("Miguel", hashTable.get(4557L));
    }

    @Test
    void contains() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(4557L, "Miguel");
        hashTable.put(4567L, "Daniel");
        hashTable.put(1234L, "Magalí");
        assertTrue(hashTable.contains(1234L));
        assertTrue(hashTable.contains(4557L));
        assertFalse(hashTable.contains(6789L));
    }

    @Test
    void remove() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(1234L, "Magalí");
        hashTable.put(4557L, "Miguel");
        hashTable.put(4562L, "José");
        hashTable.put(4553L, "Renata");
        hashTable.put(4567L, "Florencia");
        hashTable.put(4550L, "Martín");
        hashTable.put(1231L, "Agustina");
        hashTable.put(1231L, "Carla");
        hashTable.put(1235L, "Santiago");
        hashTable.put(4566L, "Belén");
        hashTable.put(4562L, "Germán");
        hashTable.remove(1234L);
        hashTable.remove(4557L);
        hashTable.remove(1233L);
        assertFalse(hashTable.contains(1234L));
        assertFalse(hashTable.contains(4557L));
    }

    @Test
    void removeWithRehashing() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(1234L, "Magalí");
        hashTable.put(4567L, "Florencia");
        hashTable.put(4557L, "Miguel");
        hashTable.put(1231L, "Carla");
        hashTable.remove(1234L);
        hashTable.remove(4557L);
        hashTable.remove(1233L);
        assertFalse(hashTable.contains(1234L));
        assertFalse(hashTable.contains(4557L));
    }

    @Test
    void get() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(1234L, "Magalí");
        hashTable.put(4567L, "Daniel");
        hashTable.put(4557L, "Miguel");
        assertEquals("Magalí", hashTable.get(1234L));
        assertEquals("Miguel", hashTable.get(4557L));
        assertNull(hashTable.get(5578L));
        assertNull(hashTable.get(6789L));
    }


    @Test
    void getSize() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(1234L, "Magalí");
        hashTable.put(4567L, "Daniel");
        hashTable.put(4557L, "Miguel");
        assertEquals(0, hashTable.getSize());
    }

    @Test
    void getLoad() {
        HashTable<Long, String> hashTable = new HashTable<Long, String>(10);
        hashTable.put(1234L, "Magalí");
        hashTable.put(4587L, "Daniel");
        hashTable.put(4557L, "Miguel");
        assertEquals(3, hashTable.getLoad());
    }
}