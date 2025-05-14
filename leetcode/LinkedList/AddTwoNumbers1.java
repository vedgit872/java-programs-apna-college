package leetcode.LinkedList;

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros. */

public class AddTwoNumbers1 {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(l1.val + l2.val);
        ListNode head = curr;
        if (curr.val > 9) {
            curr.next = new ListNode(1);
            curr.val %= 10;
        }
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            if (curr.next == null) {
                curr.next = new ListNode(0);
            }
            curr = curr.next;
            if (l1 == null) {
                curr.val = curr.val + l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.val = curr.val + l1.val;
                l1 = l1.next;
            } else {
                curr.val = curr.val + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (curr.val > 9) {
                curr.next = new ListNode(1);
                curr.val %= 10;
            }
        }
        return head;
    }
}
