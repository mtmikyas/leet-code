/**
 * Given an integer x, return true if x is palindrome integer. *
 * An integer is a palindrome when it reads the same backward as forward. *
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * -231 <= x <= 231 - 1
 */
public class Q0009PalindromeNumberEasy {

    public static void main(String[] args) {

        System.out.println("-121 is polindrome : " + isPalindrome(-121));
        System.out.println("1 is polindrome : " + isPalindrome(1));
        System.out.println("121 is polindrome : " + isPalindrome(121));
        System.out.println("10 is polindrome : " + isPalindrome(10));
        System.out.println("44 is polindrome : " + isPalindrome(44));
        System.out.println("102303201 is polindrome : " + isPalindrome(102303201));
    }

    /**
     * mine
     */
    public static boolean isPalindrome(int x) {
        int value = x, reverse = 0;
        while (value > 0) {
            reverse = reverse * 10 + value % 10;
            value = value / 10;
            if (reverse == x) return true;
        }
        return reverse == x;
    }
}
