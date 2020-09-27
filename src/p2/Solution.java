package p2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode value = new ListNode(val);
            current.next = value;
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }

        while (l2 !=null) {
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode value = new ListNode(val);
            current.next = value;
            l2 = l2.next;
            current = current.next;
        }

        while (l1 !=null) {
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode value = new ListNode(val);
            current.next = value;
            l1 = l1.next;
            current = current.next;
        }

        if(carry != 0) {
            ListNode value = new ListNode(carry);
            current.next = value;
        }

        return result.next;
    }
}
