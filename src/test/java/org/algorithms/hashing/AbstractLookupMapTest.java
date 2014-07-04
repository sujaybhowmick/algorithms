package org.algorithms.hashing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractLookupMapTest {

    private static final int TEST_SIZE = 1000;

    private LookupMap hashTable;

    public abstract LookupMap createHashTable(int capacity);

    public abstract LookupMap createHashTable();

    @Before
    public void setUp() throws Exception {
        hashTable = createHashTable(TEST_SIZE);
    }

    @Test
    public void testAdd() throws Exception {
        String value = "Sujay";
        hashTable.add(value);
        assertEquals(1, hashTable.size());
    }

    @Test
    public void testContains() throws Exception {
        String value = "Sujay";
        hashTable.add(value);
        boolean actual = hashTable.contains(value);
        assertTrue(actual);
    }

    @Test
    public void testSize() throws Exception {
       hashTable.add("Sujay");
       int actual = hashTable.size();
       assertEquals(1, actual);
    }
}