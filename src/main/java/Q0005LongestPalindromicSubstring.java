import java.util.LinkedList;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1: *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Example 2: *
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class Q0005LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println("babad : " + longestPalindrome("babad"));
        System.out.println("cbbd : " + longestPalindrome("cbbd"));
        System.out.println("bdabad : " + longestPalindrome("bdabad"));
        System.out.println("xdysbdabybadx -> dabybad: " + longestPalindrome("xdysbdabybadx"));
        System.out.println("qwerty : " + longestPalindrome("qwerty"));

    }

    /**
     * mine
     */
    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int len = 0; i + len < charArray.length; len++) {
                if (isPalindrome(charArray, i, len) && len + 1 > maxLen) {
                    maxLen = len + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static boolean isPalindrome(char[] charArray, int start, int len) {
        while (len > 0) {
            if (charArray[start] != charArray[start + len]) {
                return false;
            }
            start++;
            len -= 2;
        }

        return true;
    }

}
