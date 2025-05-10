package leetcode.LinkedList;

/*Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz */

public class RemoveNthNodeFromLL {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode begin = head;
        int i = 1;
        while (head.next != null) {
            i++;
            head = head.next;
        }
        n = i - n + 1;
        head = begin;
        n--;
        ListNode previous = null;
        while (n != 0) {
            n--;
            previous = head;
            head = head.next;
        }
        if (previous == null) {
            begin = head.next;
            head.next = null;
            return begin;
        }
        previous.next = head.next;
        head.next = null;
        return begin;
    }

    public static void main(String[] args) {

    }
}
