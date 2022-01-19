package com.mikyas.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 * <p>
 * Input: haystack = "", needle = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */
public class Q0028ImplementstrStrEasy {
    public static void main(String[] args) {
        System.out.println(" 2 : " + strStr("hello", "ll"));
        System.out.println(" -1 : " + strStr("aaaaaaa", "bba"));
        System.out.println(" 0 : " + strStr("", ""));
        System.out.println(" 0 : " + strStr("a", "a"));
        System.out.println(" 0 : " + strStr("xyxz", "xyxz"));
        System.out.println(" 2 : " + strStr("abc", "c"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.equals(needle))
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }

        }
        return -1;
    }
}
