package com.mikyas.leetcode;

import java.util.stream.IntStream;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Q0004MedianOfTwoSortedArraysHard {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 7}, new int[]{3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numArray = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).distinct().sorted().toArray();
        double median;
        if (numArray.length % 2 == 0)
            median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
        else median = numArray[numArray.length / 2];
        return median;
    }
}
