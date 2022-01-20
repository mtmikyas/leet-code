package com.mikyas.leetcode;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class Q0020ValidParenthesesEasy {
    public static void main(String[] args) {
        System.out.println("(] is false : " + isValid("(] "));
        System.out.println("([]([{}])) is true : " + isValid("([]([{}]))"));
        System.out.println("([]([{]})) is false : " + isValid("([]([{]}))"));
        System.out.println("([([{}])) is false : " + isValid("([([{}]))"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == ')' || c == '}' || c == ']') {
                return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
