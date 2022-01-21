package com.mikyas.leetcode;

/**
 * oman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * Example 2:
 * <p>
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 * <p>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 3999
 */
public class Q0012IntegertoRomanMedium {
    public static void main(String[] args) {
        System.out.println("1 : " + intToRoman(1));
        System.out.println("9 : " + intToRoman(9));
        System.out.println("80 : " + intToRoman(80));
        System.out.println("390 : " + intToRoman(390));
        System.out.println("3999 : " + intToRoman(3999));
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (RomanMapEnum e : RomanMapEnum.values()) {
            while (num >= e.value) {
                result.append(e);
                num -= e.value;
            }
        }
        return result.toString();
    }

    public enum RomanMapEnum {
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);
        private final int value;

        RomanMapEnum(int value) {
            this.value = value;
        }
    }

}
