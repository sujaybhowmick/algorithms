package org.algorithms;

import org.algorithms.general.RandomPermutations;
import org.junit.Before;
import org.junit.Test;

public class RandomPermutationsTest {

    StopWatch stopWatch;
    @Before
    public void setUp(){
        this.stopWatch = new StopWatch();
    }

    @Test
    public void testRandomPermutations(){
        stopWatch.start();
        RandomPermutations randomPerm = new RandomPermutations(5);
        randomPerm.generatePermutations();
        System.out.println(randomPerm.toString());
        stopWatch.stop();
        System.out.println(String.format("Total time: %d millis",
                stopWatch.getTotalTime()));
    }

}