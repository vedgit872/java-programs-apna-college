package leetcode.LinkedList;

/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order. */

public class MergeSortedList {

    public class ListNode {
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
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null)
            return list2;
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        ListNode head1;
        ListNode next1 = list1;
        ListNode next2 = list2;
        if (next1.val < next2.val) {
            head = next1;
            next1 = next1.next;
        } else {
            head = next2;
            next2 = next2.next;
        }
        head1 = head;
        while (next1 != null && next2 != null) {
            if (next1.val < next2.val) {
                head.next = next1;
                head = head.next;
                next1 = next1.next;
            } else {
                head.next = next2;
                head = head.next;
                next2 = next2.next;
            }
        }
        while (next2 != null) {
            head.next = next2;
            head = head.next;
            next2 = next2.next;
        }
        while (next1 != null) {
            head.next = next1;
            head = head.next;
            next1 = next1.next;
        }
        return head1;
    }

    public static void main(String[] args) {

    }
}
