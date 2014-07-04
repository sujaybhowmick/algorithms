package org.algorithms.hashing;

/**
 * Created by sujay on 7/4/14.
 */
public class LookupHashTable extends AbstractLookupMap {

    public LookupHashTable(int capacity){
        super(capacity);
    }

    public LookupHashTable(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(Object value) {
        ensureCapacity();
        int index = indexFor(value);
        if(values[index] == null){
            values[index] = value;
            ++size;
        }
    }

    /**
     * This method return an index in the array using the hashing function
     * used in 'startingIndexFor' method. It searches for a open slot with the
     * bounds specified by hashed index value and the array length.
     *
     * @param value
     * @return the available index in the array
     */
    private int indexFor(Object value) {
       int start = startingIndexFor(value);
       int index = indexFor(value, start, values.length);
        if(index == -1){
            //brute force search
            index = indexFor(value, 0, start);
            assert index == -1 : "No free slots left";
        }
        return index;
    }

    private int indexFor(Object value, int start, int end){
        assert value != null : "Cannot store null values in hash table";
        for(int i = start; i < end; i++){
            if(values[i] == null || value.equals(values[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * This is the hashing function using mod on objects
     * hash code
     * @param value
     * @return
     */
    private int startingIndexFor(Object value) {
        assert value != null : "Cannot store null values in hash table";
        return Math.abs(value.hashCode() % values.length);
    }

    private void ensureCapacity() {
        if(size == values.length){
            resize();
        }
    }

    private void resize() {
        LookupHashTable copy = new
                LookupHashTable(values.length * 2);
        for(int i = 0; i < values.length; i++){
            if(values[i] != null){
                copy.add(values[i]);
            }
        }
        values = copy.values;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    /**
     * This method searches array if the object exists with in the bounds
     * constrained by the hash code calculated index and the array length. If
     * the object is not found within the bounds a brute force search is done
     * through the lower side of the array (this can happen if there is
     * collision of hash key used to calculate index)
     *
     * @param value
     * @return index of the value in array
     */
    private int indexOf(Object value) {
        int start = startingIndexFor(value);
        int index = indexOf(value, start, values.length);
        if(index == -1){
            // brute force search
            index = indexOf(value, 0, start);
        }
        return index;
    }

    private int indexOf(Object value, int start, int end){
        assert value != null : "Value cannot be null";
        for(int i = start; i < end; i++){
            if(value.equals(values[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int size() {
        return size;
    }
}
