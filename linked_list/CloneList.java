/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        
        // insert copy of node in between node and its next node
        while(curr != null) {
            Node newNode = new Node(curr.val, curr.next, null);
            curr.next = newNode;
            curr = newNode.next;
        }
        
        curr = head;
        // copy random pointer forthe new nodes created above to random of node + 1 position
        // as there are two copies of every node at this point
        while (curr != null) {
            if (curr.next != null) {
                curr.next.random = (curr.random!=null) ? curr.random.next:curr.random;
            }
            curr = (curr.next!=null) ? curr.next.next:curr.next;
        }
        
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        
        // separate the two lists
        while (curr != null && newCurr != null) {
            curr.next = (curr.next!=null) ? curr.next.next:curr.next;
            newCurr.next = (newCurr.next!=null) ? newCurr.next.next:newCurr.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        return newHead;
    }
}