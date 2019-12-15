/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode newHead = null;
        if(B.val > A.val) {
            newHead = A;
            A = A.next;
        } else {
            newHead = B;
            B = B.next;
        }
        ListNode curr = newHead;
        while (A != null && B != null) {
            if(A.val < B.val) {
                curr.next = A;
                A = A.next;
                curr = curr.next;
            } else {
                curr.next = B;
                B = B.next;
                curr = curr.next;
            }
        }
        while(A!=null) {
            curr.next = A;
            A = A.next;
            curr = curr.next;
        }
        while(B!= null) {
            curr.next = B;
            B = B.next;
            curr = curr.next;
        }
        return newHead;
        
    }
}
