package org.algorithms.hashing;

/**
 * Created by sujay on 7/4/14.
 */
public interface LookupMap<T> {
    void add(Object value);
    boolean contains(Object value);
    int size();
}