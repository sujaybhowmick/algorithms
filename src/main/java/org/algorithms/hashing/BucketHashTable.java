package org.algorithms.hashing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sujay on 7/4/14.
 */
public class BucketHashTable implements LookupMap{
    private float loadFactor;

    private List[] buckets;

    private int size;

    public BucketHashTable(int capacity, float loadFactor){
        assert capacity > 0 : "Capacity can not be less than 0";
        assert loadFactor > 0 : "Load factor can not be less than 0";
        this.loadFactor = loadFactor;
        this.buckets = new List[capacity];
    }

    public void maintainLoad(){
        if(loadExceeded()){
            resize();
        }
    }

    private void resize() {
        BucketHashTable copy = new
                BucketHashTable(buckets.length * 2, loadFactor);
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null) {
                copy.addAll(buckets[i].iterator());
            }
        }
        buckets = copy.buckets;
    }

    private void addAll(Iterator values){
        assert values != null : "Values cannot be null";
        for(Iterator ite = values; ite.hasNext();){
            add(ite.next());
        }
    }

    private boolean loadExceeded() {
        return size() > buckets.length * loadFactor;
    }

    @Override
    public void add(Object value) {
        List bucket = bucketFor(value);
        if(!bucket.contains(value)){
            bucket.add(value);
            ++size;
            maintainLoad();
        }
    }

    private List bucketFor(Object value) {
        int bucketIndex = bucketIndexFor(value);
        List bucket = buckets[bucketIndex];
        if(bucket == null){
            bucket = new LinkedList();
            buckets[bucketIndex] = bucket;
        }
        return bucket;
    }



    private int bucketIndexFor(Object value) {
        assert value != null : "Value can not be null";
        return Math.abs(value.hashCode() % buckets.length);
    }

    @Override
    public boolean contains(Object value) {
        int bucketIndex = bucketIndexFor(value);
        List bucket = buckets[bucketIndex];
        return bucket != null && bucket.contains(value);
    }

    @Override
    public int size() {
        return size;
    }
}
