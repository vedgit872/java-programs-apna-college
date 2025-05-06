package leetcode.LinkedList;

/*Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109 */

public class RotateList {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode next = head;
        int i = 1;
        while (next.next != null) {
            i++;
            next = next.next;
        }
        k %= i;
        ListNode head1;
        ListNode next1 = head;
        for (int j = 1; j < i - k; j++) {
            next1 = next1.next;
        }
        next.next = head;
        head1 = next1.next;
        next1.next = null;

        return head1;
    }

    public static void main(String[] args) {

    }
}
