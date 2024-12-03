package com.aoc.problems;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProblemBTest {

    ProblemB nB = new ProblemB("problem2_data_test.txt");

    @Test
    public void safeReportsTest(){
        nB.cookData();
        assertEquals(nB.safeReportCount(), 2);
    }

    @Test
    public void safeSingleLevelFailure(){
        nB.cookData();
        assertEquals(nB.safeReportSingleLevelFailureCount(), 4);
    }
}
