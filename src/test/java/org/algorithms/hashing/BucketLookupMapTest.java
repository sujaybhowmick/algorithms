package org.algorithms.hashing;

public class BucketLookupMapTest extends AbstractLookupMapTest {

    static final int DEFAULT_CAPACITY = 10;

    @Override
    public LookupMap createHashTable(int capacity) {
        return new BucketLookupMap(capacity, 0.75f);
    }

    @Override
    public LookupMap createHashTable() {
        return createHashTable(DEFAULT_CAPACITY);
    }

}