public class Solution {
    public ListNode getIntersectionNode(ListNode heada, ListNode headb) {
        
        if(heada == null || headb == null){
            return null;
        }
        ListNode a = heada, b = headb;
        
        while(a!=b){
            a = (a==null) ? headb : a.next;
            b = (b==null) ? heada : b.next;
        }
        return a;
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode tempA = a;
        ListNode tempB = b;
        
        while(tempA!=null && tempB!=null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        int count = 0;
        boolean isAgreater = false;
        while(tempA != null){
            count++;
            isAgreater = true;
            tempA = tempA.next;
        }
        while(tempB != null) {
            count++;
            tempB = tempB.next;
        }
        tempA = a;
        tempB = b;
        if(isAgreater) {
            while(count-- > 0) {
                tempA = tempA.next;
            }
            
        } else {
            while(count-- > 0) {
                tempB = tempB.next; 
            }
        }
        ListNode intersection = null;
        while(tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        intersection = tempA;
        return intersection;
    }
}
