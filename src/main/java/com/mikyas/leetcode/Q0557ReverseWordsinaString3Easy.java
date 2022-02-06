package com.mikyas.leetcode;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * <p>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space
 */
public class Q0557ReverseWordsinaString3Easy {

    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words)
            sb.append(new StringBuffer(word).reverse()).append(" ");
        return sb.toString().trim();
    }
}
