package com.aoc.factory;

import java.util.HashMap;
import java.util.Map;

import com.aoc.problems.Problem;
import com.aoc.problems.ProblemA;
import com.aoc.problems.ProblemB;
import com.aoc.problems.ProblemC;

public class ProblemFactory {
    private static final Map<String, Problem> problemMap = new HashMap<>();

    static {
        problemMap.put("1", new ProblemA("problem1_data.txt"));
        problemMap.put("2", new ProblemB("problem2_data.txt"));
        problemMap.put("3", new ProblemC("problem3_data.txt"));
        //problemMap.put("3", new ProblemB("problem2_data.txt"));
        // Add more mappings as needed
    }

    public static Problem getProblem(String problemKey) {
        return problemMap.get(problemKey);
    }
}
