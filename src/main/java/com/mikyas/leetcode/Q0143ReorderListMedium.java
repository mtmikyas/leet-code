package com.mikyas.leetcode;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */
public class Q0143ReorderListMedium {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode1);
        System.out.println(listNode1);
        reorderList(listNode2);
        System.out.println(listNode2);
    }

    public static void reorderList(ListNode head) {
        ListNode[] left = new ListNode[1];// it will create in heap
        left[0] = head;
        reorder(left, head);

    }

    // left pointer will be created in heap and right pointer will be created in stack
    public static void reorder(ListNode[] left, ListNode right) {
        if (right == null) {
            return;
        }
        reorder(left, right.next);

        // in post area of recursion right pointer coming back(because of function remove from recursion stack)
        // and we move left pointer forward
        if (left[0].next != null) {
            ListNode leftNext = left[0].next;
            left[0].next = right;
            right.next = leftNext;
            left[0] = leftNext;
        }

        // as we need to this merge till left pointer behind the right pointer
        if (left[0].next == right) {
            left[0].next = null;
        }
    }
}
