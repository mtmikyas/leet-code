package com.mikyas.leetcode;

import java.util.LinkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 1 - 2 - 3 - 4 - 5
 * 1 - 2 - 3 - 5
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 */
public class Q0019RemoveNthNodeFromEndOfListMedium {
    public static void main(String[] args) {
        System.out.println("1,2,3,5 : " + removeNthFromEnd2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(" : " + removeNthFromEnd(new ListNode(1), 1));
        System.out.println("1 : " + removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));

    }

    /**
     * mine
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head.next != null) {
            linkedList.add(0, head.val);
            head = head.next;
        }
        linkedList.add(0, head.val);
        ListNode node = null;
        for (int i = 0; i < linkedList.size(); i++) {
            if (i == n - 1)
                continue;
            int digit = linkedList.get(i);
            node = new ListNode(digit, node);
        }
        return node;
    }

    /**
     * best
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
