/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode curr = A;
        while (curr != null) {
            ListNode x = curr;
            while(x.next != null && x.next.val == x.val) {
                x = x.next;
            }
            curr.next = x.next;
            curr = curr.next;
        }
        return A;
    }
}
