package com.mikyas.leetcode;

import java.util.Arrays;

/**
 * *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * <p>
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class Q0977SquaresOfASortedArrayEasy {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10, 11})));
    }


    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1, counter = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[counter] = nums[i] * nums[i];
                i++;
            } else {
                result[counter] = nums[j] * nums[j];
                j--;
            }
            counter--;
        }
        return result;
    }
}
