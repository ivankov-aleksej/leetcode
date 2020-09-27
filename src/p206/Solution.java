package p206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode reverse = null;

        while(current != null) {
            ListNode next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }

        return reverse;
    }
}
