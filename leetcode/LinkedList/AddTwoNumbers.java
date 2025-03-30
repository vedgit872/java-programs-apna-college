package leetcode.LinkedList;

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1] */
public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0;
        int curr = l1.val + l2.val;
        if (curr > 9) {
            curr %= 10;
            next = 1;
        }
        ListNode add = new ListNode(curr, null);
        ListNode prev = add;
        ListNode n = null;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            curr = l1.val + l2.val + next;
            if (curr > 9) {
                curr %= 10;
                next = 1;
            } else {
                next = 0;
            }
            n = new ListNode(curr, null);
            prev.next = n;
            prev = n;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            curr = l1.val + next;
            if (curr > 9) {
                curr %= 10;
                next = 1;
            } else {
                next = 0;
            }
            n = new ListNode(curr, null);
            prev.next = n;
            prev = n;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr = l2.val + next;
            if (curr > 9) {
                curr %= 10;
                next = 1;
            } else {
                next = 0;
            }
            n = new ListNode(curr, null);
            prev.next = n;
            prev = n;
            l2 = l2.next;
        }
        if (next == 1) {
            n = new ListNode(next, null);
            prev.next = n;
            prev = n;
        }
        return add;
    }

    public static void main(String args[]) {

    }
}
