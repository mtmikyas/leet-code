package com.mikyas.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * <p>
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * <p>
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 */
public class Q0118PascalsTriangle2Easy {
    public static void main(String[] args) {
        System.out.println("0 : " + getRow(0));
        System.out.println("1 : " + getRow(1));
        System.out.println("2 : " + getRow(2));
        System.out.println("3 : " + getRow(3));
        System.out.println("4 : " + getRow2(4));
    }

    /**
     * mine
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    innerList.add(1);
                } else {
                    innerList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(innerList);
        }
        return result.get(rowIndex);
    }

    /**
     * best
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0, 1);
            for (int j = 1; j < i; j++)
                result.set(j, result.get(j) + result.get(j + 1));
        }
        return result;
    }
}
