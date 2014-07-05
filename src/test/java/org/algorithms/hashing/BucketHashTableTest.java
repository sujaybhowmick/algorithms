package org.algorithms.hashing;

public class BucketHashTableTest extends AbstractLookupMapTest {

    static final int DEFAULT_CAPACITY = 10;

    @Override
    public LookupMap createHashTable(int capacity) {
        return new BucketHashTable(capacity, 0.75f);
    }

    @Override
    public LookupMap createHashTable() {
        return createHashTable(DEFAULT_CAPACITY);
    }

}