package p83;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode node = head;
        ListNode next = node.next;
        while(next != null){
            if(node.val == next.val) {
                node.next = next.next;
                next = next.next;
            } else {
                node = next;
                next = node.next;
            }
        }
        return head;
    }
}
