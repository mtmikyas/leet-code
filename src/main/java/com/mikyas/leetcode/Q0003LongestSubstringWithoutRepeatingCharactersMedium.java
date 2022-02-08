package com.mikyas.leetcode;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class Q0003LongestSubstringWithoutRepeatingCharactersMedium {
    public static void main(String[] args) {
        System.out.println("abcabcbb result : " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("pwwkew result : " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("bbbbb result : " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("xyzzabcdzxabcde result : " + lengthOfLongestSubstring("xyzzabcdzxabcde"));
        System.out.println(" result : " + lengthOfLongestSubstring(""));
    }


    /**
     * mine
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        String[] arr = s.split("");
        HashMap<String, Integer> hashMap = new HashMap<>();
        int diff = 0;
        int tempDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                tempDiff = Math.max(hashMap.get(arr[i]), tempDiff);
                hashMap.put(arr[i], tempDiff);
            }
            diff = Math.max(diff, i - tempDiff + 1);
            hashMap.put(arr[i], i + 1);
        }
        return diff;
    }
}
