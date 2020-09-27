package p21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode copyL1 = l1;
        ListNode copyL2 = l2;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (copyL1 != null || copyL2 != null){
            if(copyL1 == null) {
                temp.next = copyL2;
                copyL2 = copyL2.next;
                temp = temp.next;
            }else if(copyL2 == null) {
                temp.next = copyL1;
                copyL1 = copyL1.next;
                temp = temp.next;
            } else {
                if(copyL1.val <= copyL2.val) {
                    temp.next = new ListNode(copyL1.val);
                    copyL1 = copyL1.next;
                    temp = temp.next;
                }else {
                    temp.next = new ListNode(copyL2.val);
                    copyL2 = copyL2.next;
                    temp = temp.next;
                }
            }
        }
        return result.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next=mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        ListNode next1 = new ListNode(2);
//        l1.next = next1;
//        ListNode next2 = new ListNode(4);
//        next1.next = next2;
//
//        ListNode l2 = new ListNode(1);
//        next1 = new ListNode(3);
//        l2.next = next1;
//        next2 = new ListNode(4);
//        next1.next = next2;

        ListNode l1 = new ListNode(0);
        ListNode temp = l1;
        for (int i = 2; i < 1000000 ; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode l2 = new ListNode(0);
        temp = l2;
        for (int i = 1; i < 1000000 ; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
