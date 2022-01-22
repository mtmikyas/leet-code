package com.mikyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public class Q0022GenerateParenthesesMedium {
    public static void main(String[] args) {
        //{"()"}
        System.out.println("1 : " + generateParenthesis(1));
        //"{(())","()()"}
        System.out.println("2 : " + generateParenthesis(2));
        //"{((()))","(()())","(())()","()(())","()()()"}
        System.out.println("3 : " + generateParenthesis(3));
        //{"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"}
        System.out.println("4 : " + generateParenthesis(4));
        //{"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"}
        System.out.println("5 : " + generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        createElement(result, "", 0, 0, n);
        return null;
    }

    public static void createElement(List<String> result, String element, int left, int right, int max) {

        if (element.length() == max * 2) {
            result.add(element);
            return;
        }
        if (left < max)
            createElement(result, element + "(", left + 1, right, max);
        if (right < left)
            createElement(result, element + ")", left, right + 1, max);
    }
}
