package leetcode.LinkedList;

/*Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200 */

public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode before = null;
        ListNode after = null;
        ListNode beforehead = null;
        ListNode afterhead = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (before == null) {
                    beforehead = curr;
                    before = curr;
                } else {
                    before.next = curr;
                    before = before.next;
                }
                curr = curr.next;
                before.next = null;
            } else {
                if (after == null) {
                    afterhead = curr;
                    after = curr;
                } else {
                    after.next = curr;
                    after = after.next;
                }
                curr = curr.next;
                after.next = null;
            }
        }
        if (beforehead == null) {
            return afterhead;
        }
        head = beforehead;
        before.next = afterhead;
        return head;
    }

    public static void main(String[] args) {

    }
}
