// In iterative, add nodes to a queue, dequeue while queue exists
// and switch left and right children
class Node
{
    int data;
    Node left, right;
   Node(int item)    
   {
        data = item;
        left = right = null;
    }
} */
class Tree
{
    void mirror(Node node)
    {
	    if (node == null) {
	        return;
	    }
	    mirror(node.left);
	    mirror(node.right);
	    Node temp = new Node(0);
	    temp.left = node.left;
	    node.left = node.right;
	    node.right = temp.left;
	    return;
    }
}