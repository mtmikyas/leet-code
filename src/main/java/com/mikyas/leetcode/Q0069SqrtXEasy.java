package com.mikyas.leetcode;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= x <= 231 - 1
 */
public class Q0069SqrtXEasy {

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(9));
    }

    /**
     * mine
     */
    public static int mySqrt(int x) {
        for (int divisor = 1; divisor <= x; divisor++) {
            int quotient = x / divisor;
            if (quotient * quotient == x) {
                return quotient;
            } else if (divisor > quotient) {
                return divisor - 1;
            }
        }
        return 0;
    }

    /**
     * best
     * binary search
     */
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;
        // Binary Search
        int left = 0, right = x;
        while (left < right) {
            // mid = (left + right) / 2 can overflow if right > Integer.MAX_VALUE - left
            int mid = left + (right - left) / 2;
            // same thing here , mid * mid > x can overflow. replace by mid > x / mid
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                // if mid * mid < x but (mid + 1) * (mid + 1) > x then mid was the right answer
                if (left > x / left) {
                    return mid;
                }
            }
        }
        return left;
    }
}
