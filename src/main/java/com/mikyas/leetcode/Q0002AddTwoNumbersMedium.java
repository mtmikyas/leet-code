package com.mikyas.leetcode;

import java.util.LinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class Q0002AddTwoNumbersMedium {
    public static void main(String[] args) {

        ListNode test1l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode test1l2 = new ListNode(5, new ListNode(6, new ListNode(7)));

        ListNode test2l1 = new ListNode(0);
        ListNode test2l2 = new ListNode(0);

        ListNode test3l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode test3l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(addTwoNumbers2(test1l1, test1l2));
//        System.out.println(addTwoNumbers(test2l1, test2l2));
//        System.out.println(addTwoNumbers(test3l1, test3l2));
//        addTwoNumbers(test2l1, test2l2);
//        addTwoNumbers(test3l1, test3l2);
    }

    /**
     * mine
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = getLinkedList(l1, new LinkedList<>());
        LinkedList<Integer> list2 = getLinkedList(l2, new LinkedList<>());
        LinkedList<Integer> result = new LinkedList<>();
        int counter = Math.max(list1.size(), list2.size());
        boolean hasDecimal = false;
        int sum = 0;
        for (int i = 0; i < counter; i++) {
            Integer first = list1.pollFirst();
            Integer second = list2.pollFirst();
            int partSum = (first != null ? first : 0) + (second != null ? second : 0);
            sum = hasDecimal ? partSum + 1 : partSum;
            hasDecimal = sum >= 10;
            result.push(sum % 10);
        }
        if (sum >= 10) {
            result.push(1);
        }
        return toListNode(result);
    }

    /**
     * best
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return result.next;
    }

    private static int carryR = 0;

    /**
     * Recursion solution
     */
    public static ListNode addTwoNumbersR(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null && carryR == 0) {
            return null;
        }

        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        int sum = val1 + val2 + carryR;
        carryR = sum / 10;

        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;

        return new ListNode(sum % 10, addTwoNumbersR(l1, l2));
    }

    private static ListNode toListNode(LinkedList<Integer> list) {
        ListNode node = new ListNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int digit = list.get(i);
            node = new ListNode(digit, node);
        }
        return node;
    }

    private static LinkedList<Integer> getLinkedList(ListNode node, LinkedList<Integer> list) {
        list.add(node.val);
        if (hasNext(node)) {
            return getLinkedList(node.next, list);
        } else {
            return list;
        }
    }

    private static boolean hasNext(ListNode node) {
        return node.next != null;
    }

}
