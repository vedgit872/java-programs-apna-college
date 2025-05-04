package leetcode.LinkedList;

/*Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space? */

public class PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int arr[] = new int[100000];
        int i = 0;
        arr[i] = head.val;
        head = head.next;
        i++;
        while (head != null) {
            arr[i] = head.val;
            head = head.next;
            i++;
        }
        int n = i-- / 2;
        for (int j = 0; j < n; j++) {
            if (arr[j] != arr[i - j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
