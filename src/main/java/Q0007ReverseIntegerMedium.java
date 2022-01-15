import java.util.HashMap;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: x = 120
 * Output: 21
 */
public class Q0007ReverseIntegerMedium {
    public static void main(String[] args) {
        System.out.println(" 123 result is 321 : " + reverse(123));
        System.out.println(" -123 result is -321 : " + reverse(-123));
        System.out.println(" 120 result is 21 : " + reverse(120));
        System.out.println(" 1534236469 result is 0 : " + reverse(1534236469));
    }


    /**
     * mine
     */
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }
}
