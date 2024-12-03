package com.aoc.factory;

import java.util.HashMap;
import java.util.Map;

import com.aoc.problems.Problem;
import com.aoc.problems.ProblemDay1;
import com.aoc.problems.ProblemDay2;
import com.aoc.problems.ProblemDay3;

public class ProblemFactory {
    private static final Map<String, Problem> problemMap = new HashMap<>();

    static {
        problemMap.put("1", new ProblemDay1("problem1_data.txt"));
        problemMap.put("2", new ProblemDay2("problem2_data.txt"));
        problemMap.put("3", new ProblemDay3("problem3_data.txt"));
        //problemMap.put("3", new ProblemB("problem2_data.txt"));
        // Add more mappings as needed
    }

    public static Problem getProblem(String problemKey) {
        return problemMap.get(problemKey);
    }
}
