/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A == null || (A.next == null && B > 0)) return null;
        ListNode temp = A;
        int count = B;
        for(int i=0;i<B;i++) {
            if(temp.next != null){
                temp = temp.next;    
            } else {
                return A.next;
            }
            
        }
        ListNode prev = A;
        while(temp.next != null) {
            prev = prev.next;
            temp = temp.next;
        }
        prev.next = prev.next.next;
        return A;
    }
}
