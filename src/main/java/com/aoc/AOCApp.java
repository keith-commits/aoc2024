package com.aoc;

import java.util.Scanner;

import com.aoc.problems.Problem;
import com.aoc.factory.ProblemFactory;


public class AOCApp 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the problem day identifier (e.g., 1, 2):");
        String input = scanner.nextLine().toUpperCase();

        Problem problem = ProblemFactory.getProblem(input);
        if (problem != null) {
            problem.cookData();
            problem.solve();
        } else {
            System.out.println("Invalid problem identifier. Please try again.");
        }
        scanner.close();
    }
}
