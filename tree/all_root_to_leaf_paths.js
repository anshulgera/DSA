/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var explorePaths = (root, s, paths) => {
    
    if (root == null) {
        return
    } else {
        s += root.val;        
    }
    
    if (root.left != null) {
        explorePaths(root.left, s+"->", paths);
    }
    if (root.right != null) {
        explorePaths(root.right, s+"->", paths);
    }
    if (root.left == null && root.right == null) {
        paths.push(s);
    }
    return
}
var binaryTreePaths = function(root) {
    s = "";
    paths = [];
    explorePaths(root, s, paths);
    return paths;
};