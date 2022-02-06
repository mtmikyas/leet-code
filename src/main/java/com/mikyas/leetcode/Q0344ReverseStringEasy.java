package com.mikyas.leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = ['h','e','l','l','o']
 * Output: ['o','l','l','e','h']
 * Example 2:
 * <p>
 * Input: s = ['H','a','n','n','a','h']
 * Output: ['h','a','n','n','a','H']
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class Q0344ReverseStringEasy {
    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
        System.out.println(s);

    }
}
