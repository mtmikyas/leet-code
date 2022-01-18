package com.mikyas.leetcode;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * Example 2:
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * Example 3:
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 */
public class Q0008StringToIntegerMedium {
    public static void main(String[] args) {
        System.out.println("myAtoi 123 : " + myAtoi("123-"));
        System.out.println("myAtoi 0 : " + myAtoi("  +  413"));
        System.out.println("myAtoi 0 : " + myAtoi(" - 413"));
        System.out.println("myAtoi 0 : " + myAtoi("- 413"));
        System.out.println("myAtoi -413 : " + myAtoi(" -413"));
        System.out.println("myAtoi 0 : " + myAtoi(""));
        System.out.println("myAtoi 0 : " + myAtoi("  "));
        System.out.println("myAtoi 0 : " + myAtoi("   - asd - "));
        System.out.println("myAtoi 0 : " + myAtoi("--12"));
        System.out.println("myAtoi -12 : " + myAtoi("-12-"));
        System.out.println("myAtoi -12 : " + myAtoi("-12 +"));
        System.out.println("myAtoi -12 : " + myAtoi("-12 45"));
        System.out.println("myAtoi 0 : " + myAtoi("-+12"));
        System.out.println("myAtoi 0 : " + myAtoi("+-12"));
        System.out.println("myAtoi 0 : " + myAtoi("++12"));
        System.out.println("myAtoi 42 : " + myAtoi("42"));
        System.out.println("myAtoi -42 : " + myAtoi("   -42"));
        System.out.println("myAtoi 4193 : " + myAtoi("4193 with words"));
        System.out.println("myAtoi 123441 : " + myAtoi("   +123441 with words"));
        System.out.println("myAtoi -98741 : " + myAtoi("   -98741 with words"));
        System.out.println("myAtoi -max int : " + myAtoi("   -12567891011121314 with words"));
        System.out.println("myAtoi 0 : " + myAtoi("words and 987"));
        System.out.println("myAtoi 0 : " + myAtoi(".1"));
        System.out.println("myAtoi 0 : " + myAtoi(" b11228552307"));
        System.out.println("myAtoi 0 : " + myAtoi(" .1123"));
    }

    /**
     * mine
     */
    public static int myAtoi(String s) {
        if (s.length() == 0 || (Character.isLetter(s.charAt(0)) || s.charAt(0) == '.')) {
            return 0;
        }
        boolean isSign = false;
        boolean isNegativeMultiplier = false;
        boolean digitPartStarted = false;
        StringBuilder tempResult = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!digitPartStarted && (Character.isLetter(s.charAt(i)) || s.charAt(i) == '.')){
                return 0;
            }
            if (!isNegativeMultiplier && s.charAt(i) == '-' && !digitPartStarted) {
                isNegativeMultiplier = true;
            }
            if (((s.charAt(i) == '-' ||s.charAt(i) == '+') && isSign) || (!Character.isDigit(s.charAt(i)) && isSign)) {
                return 0;
            }
            isSign = s.charAt(i) == '+' || s.charAt(i) == '-';
            if (Character.isDigit(s.charAt(i))) {
                digitPartStarted = true;
                tempResult.append(s.charAt(i));
            } else if (tempResult.length() > 0) {
                return getIntValue(isNegativeMultiplier, tempResult.toString());
            }
        }
        return digitPartStarted ? getIntValue(isNegativeMultiplier, tempResult.toString()) : 0;
    }

    private static int getIntValue(boolean isNegative, String tempResult) {
        try {
            return isNegative ? -1 * Integer.parseInt(tempResult) : Integer.parseInt(tempResult);
        } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }


}
