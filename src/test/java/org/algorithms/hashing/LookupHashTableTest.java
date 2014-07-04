package org.algorithms.hashing;

/**
 * Created by sujay on 7/4/14.
 */
public class LookupHashTableTest extends AbstractLookupMapTest {
    @Override
    public LookupMap createHashTable(int capacity) {
        return new LookupHashTable(capacity);
    }

    @Override
    public LookupMap createHashTable() {
        return new LookupHashTable();
    }
}
