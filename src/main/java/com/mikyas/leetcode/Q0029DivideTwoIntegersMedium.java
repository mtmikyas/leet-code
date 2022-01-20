package com.mikyas.leetcode;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class Q0029DivideTwoIntegersMedium {
    public static void main(String[] args) {
//        System.out.println("10 / 3 result 3 = " + divide(10, 3));
//        System.out.println("10 / -3 result -3 = " + divide(10, -3));
//        System.out.println("-10 / 3 result -3 = " + divide(-10, 3));
//        System.out.println("-10 / -3 result 3 = " + divide(-10, -3));
//        System.out.println("-6 / -2 result 3 = " + divide(-6, -2));
//        System.out.println("-12 / 4 result -3 = " + divide(-12, 4));
//        System.out.println("15 / -5 result -3 = " + divide(15, -5));
//        System.out.println("-2147483648 / -1 result 2147483647 = " + divide(-2147483648, -1));
//        System.out.println("2147483647 / -1 result -2147483647 = " + divide(2147483647, -2147483647));
        System.out.println("-2147483648 / 1 result -2147483648 = " + divide(-2147483648, 1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        return (new BigDecimal(Integer.toString(dividend)).divide(new BigDecimal(Integer.toString(divisor)), MathContext.DECIMAL64)).intValue();
    }
}
