package com.mikyas.leetcode;

import java.util.Random;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
public class Q0011ContainerWithMostWater {
    public static void main(String[] args) {
//        System.out.println("result 1 : " + maxArea(getTestArray1()));
        System.out.println("result 2 : " + maxArea(getTestArray2()));
    }

    /**
     * mine
     */
    public static int maxArea(int[] height) {
        int size = height.length;
        if (size == 1) {
            return 0;
        }
        if (size == 2) {
            return Math.min(height[0], height[1]);
        }

        int left = 0;
        int right = size - 1;
        int result = 0;

        while (left != right) {
            int distance = right - left;
            if (height[left] < height[right]) {
                result = Math.max(result, height[left] * distance);
                left++;
            } else {
                result = Math.max(result, height[right] * distance);
                right--;
            }
        }
        return result;
    }

    private static int[] getTestArray1() {
        return new int[]{5, 8, 3, 7, 1, 9, 5, 4, 2, 6, 3};
    }

    private static int[] getTestArray2() {
        int size =  new Random().nextInt(1000);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
             arr[i] = new Random().nextInt(10000);
        }
        return arr;
    }
}
