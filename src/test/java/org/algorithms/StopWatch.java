package org.algorithms;

import java.util.AbstractList;

/**
 * Created by sujay on 7/2/14.
 */
public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){

    }

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        endTime = System.currentTimeMillis();
    }

    public long getTotalTime(){
        return endTime - startTime;
    }
}
