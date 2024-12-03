package com.aoc.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.aoc.utils.ProblemFileUtils;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProblemA implements Problem {

    List<List<Integer>> data = new ArrayList<>();
    String dataPath;

    public ProblemA(String dataPath){
        this.dataPath = dataPath;
    }

    @Override
    public void solve() {
        System.out.println("the total distance is " + solveForDistance());        
        System.out.println("The similarity score is " + solveForSimilarityScore());
    }

    @Override
    public void cookData() {
        List<String> locationList = ProblemFileUtils.readLinesAsList(dataPath);
        List<Integer> leftLocation = new ArrayList<>();
        List<Integer> rightLocation = new ArrayList<>();

        for (String string : locationList) {
            String parts[] = string.split("   ");
            leftLocation.add(Integer.parseInt(parts[0]));
            rightLocation.add(Integer.parseInt(parts[1]));
        }
        Collections.sort(leftLocation);
        Collections.sort(rightLocation);
        data.add(leftLocation);
        data.add(rightLocation);
    }

    public long solveForSimilarityScore() {
        List<Integer> leftLocation = (List<Integer>) data.get(0);
        List<Integer> rightLocation = (List<Integer>) data.get(1);
        System.out.println("Trying to get similarity score..");
        Map<Integer, Integer> rightOccurances = new HashMap<>();
        long similaritySum = 0;
        for (Integer integer : rightLocation) {
            Integer occuranceCount = rightOccurances.get(integer);
            if (occuranceCount == null) {
                rightOccurances.put(integer, 1);
            } else {
                rightOccurances.put(integer, ++occuranceCount);
            }
        }

        for (Integer integer : leftLocation) {
            Integer simCount = rightOccurances.get(integer);
            if (simCount != null) {
                similaritySum += simCount * integer;
            }
        }

        return similaritySum;
        
    }

    public long solveForDistance() {
        List<Integer> leftLocation = (List<Integer>) data.get(0);
        List<Integer> rightLocation = (List<Integer>) data.get(1);
        long totalDistance = 0;
        for (int i = 0; i < leftLocation.size(); i++) {
            totalDistance += Math.abs(leftLocation.get(i) - rightLocation.get(i));
        }
        return totalDistance;
       
    }



    

}
