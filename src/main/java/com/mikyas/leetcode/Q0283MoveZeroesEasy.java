package com.mikyas.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 */
public class Q0283MoveZeroesEasy {
    public static void main(String[] args) {
//        moveZeroes(new int[]{0, 1, 0, 0, 2, 3, 4, 5, 6, 7, 0});
//        moveZeroes(new int[]{0, 1, 0, 0, 2, 3, 4, 5, 6, 7, 0, 8});
//        moveZeroes(new int[]{8, 0, 1, 0, 0, 2, 3, 4, 5, 6, 7, 0});
//        moveZeroes(new int[]{8, 0, 1, 0, 0, 2, 3, 4, 5, 6, 7, 0, 8});
//        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{5, 0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > left) {
                    nums[left] = nums[i];
                    nums[i] = 0;
                }
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
