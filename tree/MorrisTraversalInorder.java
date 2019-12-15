
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class MorrisTraversalInorder {
    
    public static void traversal(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        TreeNode pre = null;
        while(curr != null) {
            if(curr.left == null) {
                System.out.println(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                // create predecessor
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // here link exists as pre.right == curr
                    // undo predecessor link
                    System.out.println(pre.val);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        traversal(root);
    } 
    
}