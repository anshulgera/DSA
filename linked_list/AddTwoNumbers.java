/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode head = null;
        ListNode curr = null;
        while(A!=null || B!=null || carry!=0) {
            int data = 0;
            if(A != null) {
                data += A.val;
                A = A.next;
            }
            if(B != null) {
                data += B.val;
                B = B.next;
            }
            if(carry != 0) {
                data += carry;
            }
            carry = data/10;
            data = data%10;
            ListNode newNode = new ListNode(data);
            if(head == null) {
                head = newNode;
                curr = newNode;
            } else {
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return head;
    }
}
