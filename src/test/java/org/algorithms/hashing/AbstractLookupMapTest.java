package org.algorithms.hashing;

import org.algorithms.StopWatch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractLookupMapTest {

    private static final int TEST_SIZE = 100000;

    private LookupMap hashTable;

    protected StopWatch stopWatch;

    public abstract LookupMap createHashTable(int capacity);

    public abstract LookupMap createHashTable();

    @Before
    public void setUp() throws Exception {
        hashTable = createHashTable(TEST_SIZE);
        stopWatch = new StopWatch();
    }

    @Test
    public void testAdd() throws Exception {
        stopWatch.reset();
        stopWatch.start();
        for(int i = 0; i < TEST_SIZE; i++) {
            hashTable.add(String.valueOf(i));
        }
        stopWatch.stop();
        assertEquals(TEST_SIZE, hashTable.size());
        System.out.println(String.format("Time taken to add a value: %d",
                                            stopWatch.getTotalTime()));
    }

    @Test
    public void testContains() throws Exception {
        stopWatch.reset();

        for(int i = 0; i < TEST_SIZE; i++) {
            hashTable.add(String.valueOf(i));
        }
        stopWatch.start();
        assertTrue(hashTable.contains("99999"));
        stopWatch.stop();
        System.out.println(String.format("Time taken to search a value: %d",
                stopWatch.getTotalTime()));
    }

    @Test
    public void testSize() throws Exception {
        stopWatch.reset();

        for(int i = 0; i < TEST_SIZE; i++) {
            hashTable.add(String.valueOf(i));
        }

        stopWatch.start();
        assertEquals(TEST_SIZE, hashTable.size());
        stopWatch.stop();
        System.out.println(String.
                format("Time taken to retrieve size of hashtable: %d",
                stopWatch.getTotalTime()));
    }
}