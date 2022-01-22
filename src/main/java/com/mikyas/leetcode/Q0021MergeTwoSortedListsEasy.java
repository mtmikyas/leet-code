package com.mikyas.leetcode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class Q0021MergeTwoSortedListsEasy {
    public static void main(String[] args) {
        ListNode test1l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode test1l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(test1l1, test1l2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 == null) {
                currentNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list1 == null) {
                currentNode.next = list2;
                list2 = list2.next;
            } else if (list1.val >= list2.val) {
                currentNode.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                currentNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            currentNode = currentNode.next;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}
