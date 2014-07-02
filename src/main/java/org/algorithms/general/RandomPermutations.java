package org.algorithms.general;

import java.util.Random;

/**
 * Created by sujay on 7/2/14.
 * Generate random permutations of the first N integers.
 * For example {4, 3, 1, 5, 2} and {3, 1, 4, 2, 5} are
 * legal permutations but {5, 4, 1, 2, 1} is not as 1 is
 * repeated. Use arrays.
 *
 */
public class RandomPermutations {
    private int permutations[];
    private int n;
    private static final int SCALE_VALUE = 100;

    public RandomPermutations(int n){
        this.n = n;
        this.permutations = new int[n];
    }
    public void generatePermutations(){
        int i = 0;
        while(i < this.n){
            int random = nextValue();
            if(!isPresent(random, i)){
                permutations[i] = random;
                i++;
            }

        }
    }

    public boolean isPresent(int randomValue, int currentSize){
        for(int i = 0; i <= currentSize; i++){
           if(permutations[i] == randomValue){
               return true;
           }
        }
        return false;
    }

    public int nextValue(){
        Random r = new Random();
        int nextInt = r.nextInt() % SCALE_VALUE;
        if(nextInt > 0) {
            return nextInt;
        }
        return nextValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0; i < this.permutations.length; i++){
            sb.append(this.permutations[i]);
            sb.append(",");
        }
        int end = sb.lastIndexOf(",");
        sb.deleteCharAt(end);
        sb.append("}");
        return sb.toString();
    }
}
