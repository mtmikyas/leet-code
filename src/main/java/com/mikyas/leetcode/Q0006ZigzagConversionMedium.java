package com.mikyas.leetcode;

/**
 * he string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class Q0006ZigzagConversionMedium {
    public static void main(String[] args) {
        System.out.println("KCMNAAAIIIIRLSZ : " + convert("KARACALIMISINIZ", 5));
        System.out.println("KMAIIRLSAANZCI : " + convert("KARACALIMISINIZ", 5));
        System.out.println("KARACALZIIMNIIS : " + convert("KARACALIMISINIZ", 11));
    }

    public static String convert(String s, int numRows) {
        int lap = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += lap) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + lap - i < s.length()) {
                    sb.append(s.charAt(j + lap - i));
                }
            }
        }
        return sb.toString();
    }
}
