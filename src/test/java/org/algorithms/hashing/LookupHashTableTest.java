package org.algorithms.hashing;

/**
 * Created by sujay on 7/4/14.
 */
public class LookupHashTableTest extends AbstractLookupMapTest {
    static final int DEFAULT_CAPACITY = 10;
    @Override
    public LookupMap createHashTable(int capacity) {
        return new LookupHashTable(capacity);
    }

    @Override
    public LookupMap createHashTable() {
        return createHashTable(DEFAULT_CAPACITY);
    }
}
