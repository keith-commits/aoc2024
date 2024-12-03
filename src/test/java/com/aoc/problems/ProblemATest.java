package com.aoc.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProblemATest {

    ProblemA a = new ProblemA("problem1_data_test.txt");

    @Test
    public void solveForDistanceTest(){
        a.cookData();
        assertEquals(a.solveForDistance(), 11);
    }

    @Test
    public void solveForSimilarityScore(){
        a.cookData();
        assertEquals(a.solveForSimilarityScore(), 31);
    }
}
