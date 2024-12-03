package com.aoc.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aoc.utils.ProblemFileUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProblemDay2 implements Problem {

    List<List<Integer>> data = new ArrayList<>();

    String dataPath;

    public ProblemDay2(String dataPath) {
        this.dataPath = dataPath;
    }

    @Override
    public void solve() {
        System.out.println("the total number of safe reports " + safeReportCount());
        System.out.println("the total number of single level safe reports " + safeReportSingleLevelFailureCount());
        // System.out.println("The similarity score is " + solveForSimilarityScore());
    }

    @Override
    public void cookData() {
        List<String> problemData = ProblemFileUtils.readLinesAsList(dataPath);
        data = problemData.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public int safeReportCount() {
        int safeReport = 0;
        for (List<Integer> list : data) {
            if(isSafeReport(list)) ++safeReport;
        }
        return safeReport;
    }

    public boolean isSafeReport(List<Integer> report) {
        if(report.size() == 2){
            return true;
        }
        boolean increasing = report.get(1) - report.get(0) > 0;
        boolean decreasing = report.get(1) - report.get(0) < 0;
        int diff = Math.abs(report.get(1) - report.get(0));
        if(!increasing && !decreasing || diff > 3) return false;
        for (int i = 2; i < report.size(); i++) {
            diff = report.get(i) - report.get(i - 1);

            if(increasing && (diff <= 0 || diff > 3)){
                return false;
            }
            if(decreasing && (diff >= 0 || diff < -3)){
                return false;
            }
        }       
        
        return true;
    }

    public int safeReportSingleLevelFailureCount() {
        int safeReport = 0;
        for (List<Integer> list : data) {
            if(isSafeReport(list)) {
                ++safeReport;
                
            }else{

                for (int i = 0; i < list.size(); i++) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.remove(i);
                    if(isSafeReport(temp)) {
                        ++safeReport;
                        break;
                    };                    
                }

            }
        }
        return safeReport;
    }

}
