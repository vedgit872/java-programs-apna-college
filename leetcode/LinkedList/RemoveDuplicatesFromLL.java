package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/*Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */

public class RemoveDuplicatesFromLL {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        int temp;
        boolean arr[] = new boolean[201];
        Set<Integer> unique = new HashSet<>();
        while (curr != null) {
            temp = curr.val;
            if (temp < 0)
                temp = temp * (-1) + 100;
            if (arr[temp] == true) {
                unique.add(curr.val);
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            } else {
                arr[temp] = true;
                prev = curr;
                curr = curr.next;
            }
        }
        prev = null;
        curr = head;
        while (curr != null) {
            if (unique.contains(curr.val)) {
                if (prev == null) {
                    head = curr.next;
                    curr.next = null;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {

    }
}
