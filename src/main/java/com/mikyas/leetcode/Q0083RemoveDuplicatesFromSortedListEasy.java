package com.mikyas.leetcode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class Q0083RemoveDuplicatesFromSortedListEasy {

    public static void main(String[] args) {

        System.out.println(" 1-2-3-4: " + deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4)))))))));
        System.out.println(" 1 : " + deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))))));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
