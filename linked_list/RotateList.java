/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode A, int B) {
        if(A == null || A.next == null) return A;
        ListNode curr = A;
        int length = 0;
        while(curr!=null) {
            curr=curr.next;
            length++;
        }
        int shift = B%length;
        if(shift == 0) return A;
        curr = A;
        for(int i=0;i<shift;i++) {
            curr = curr.next;
        }
        ListNode slow = A;
        while(curr.next != null) {
            curr = curr.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        curr.next = A;
        return newHead;
    }
}
