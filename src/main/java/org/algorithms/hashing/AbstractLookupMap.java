package org.algorithms.hashing;

/**
 * Created by sujay on 7/4/14.
 */
public abstract class AbstractLookupMap implements LookupMap {

    protected static final int DEFAULT_CAPACITY = 10;

    protected Object values[];

    protected int size;

    public AbstractLookupMap(int capacity){
        assert capacity > 0 : "Initial Capacity cannot be less than 0";
        values = new Object[capacity];
    }

    public AbstractLookupMap(){
        this(DEFAULT_CAPACITY);
    }

}
