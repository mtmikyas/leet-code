package com.mikyas.leetcode;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,5,6,8,9], target = 7
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class Q0035SearchInsertPositionEasy {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 5, 6, 8, 9}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int centerIdx = left + (right - left) / 2;
            if (nums[centerIdx] == target) {
                return centerIdx;
            } else if (target > nums[centerIdx]) {
                left = centerIdx + 1;
            } else {
                right = centerIdx - 1;
            }
        }
        return left;
    }

}
