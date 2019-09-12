class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class GfG
{
    int countLeaves(Node node) 
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while (q.size()!=0) {
            Node curr = q.peek();
            q.remove();
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (curr.left == null && curr.right == null) {
                count++;
            }
        }
        return count;
    }
}