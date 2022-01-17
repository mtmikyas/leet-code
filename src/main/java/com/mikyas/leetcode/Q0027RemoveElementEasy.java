package com.mikyas.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * // It is sorted with no values equaling val.
 * <p>
 * int k = removeElement(nums, val); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class Q0027RemoveElementEasy {

    public static void main(String[] args) {

        removeElement2(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        removeElement2(new int[]{3, 2, 2, 3}, 3);
        removeElement(new int[]{1}, 1);
    }

    /**
     * mine
     */
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        Arrays.sort(nums);
        int length = nums.length;
        int n = nums.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num < val) {
                break;
            }
            if (num == val) {
                k++;
                int temp = nums[n];
                nums[n] = nums[i];
                nums[i] = temp;
                n--;
            }
        }
        return length - k;
    }


    /**
     * best
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int element : nums) {
            if (element != val) {
                nums[i] = element;
                i++;
            }
        }
        return i;
    }

}
