package com.mikyas.leetcode;

import java.util.*;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class Q0066PlusOneEasy {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(plusOne(new int[]{0})));
//        System.out.println(Arrays.toString(plusOne(new int[]{1})));
//        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
//        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
//        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9})));
    }

    /**
     * mine
     */
    public static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int reminder = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + reminder;
            if (i == digits.length - 1)
                temp = digits[i] + 1;
            if (temp >= 10) {
                temp = temp - 10;
                reminder = 1;
            } else {
                reminder = 0;
            }
            stack.add(temp);
        }
        if (reminder > 0) {
            stack.add(1);
        }
        int size = stack.size();
        ;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     * best
     */
    public static int[] plusOne2(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
    }
}
