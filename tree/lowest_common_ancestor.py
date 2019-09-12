class BST
{   
    Node LCA(Node node, int n1, int n2) 
    {
        if (node == null) {
            return null;
        }
        if (node.data == n1 || node.data == n2) {
            return node;
        }
        Node left = LCA(node.left, n1, n2);
        Node right = LCA(node.right, n1, n2);
        
        if (left!=null && right!=null) {
            return node;
        }
        return left!=null?left:right;
    }
    
}