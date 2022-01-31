package com.mikyas.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
public class Q0058LengthOfLastWordEasy {

    public static void main(String[] args) {
        System.out.println("5 : " + lengthOfLastWord("Hello World"));
        System.out.println("4 : " + lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("6 : " + lengthOfLastWord("luffy is still joyboy"));
    }

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }
}
