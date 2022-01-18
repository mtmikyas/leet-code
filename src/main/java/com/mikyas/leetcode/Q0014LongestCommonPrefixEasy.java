package com.mikyas.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class Q0014LongestCommonPrefixEasy {

    public static void main(String[] args) {

//        System.out.println("result : " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println("result : " + longestCommonPrefix(new String[]{"flower", "flight", "fever", "f", "flaking", "flow"}));
//        System.out.println("result : " + longestCommonPrefix(new String[]{"racecar", "dog", "car"}));
        System.out.println("result : " + longestCommonPrefix(new String[]{"racecar"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        int left = 0, right = strs.length - 1;
        String result = strs[0];
        while (left != right) {
            String tempResult = "";
            if ((strs[left].length() > strs[right].length())) {
                tempResult = getArrPrefix(strs[left].split(""), strs[right].split(""), strs[right].length());
                right--;
            } else {
                tempResult = getArrPrefix(strs[left].split(""), strs[right].split(""), strs[left].length());
                left++;
            }
            if (tempResult.length() < result.length())
                result = tempResult;
        }
        return result;
    }

    private static String getArrPrefix(String[] arrLeft, String[] arrRight, int counter) {
        StringBuilder tempResult = new StringBuilder("");
        for (int i = 0; i < counter; i++) {
            String charRight = arrRight[i];
            String charLeft = arrLeft[i];
            if (charLeft.equals(charRight)) {
                tempResult.append(charRight);
            } else {
                break;
            }
        }
        return tempResult.toString();
    }
}