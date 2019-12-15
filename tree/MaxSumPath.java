/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int maxPathSumUtil(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSumUtil(node.left, result);
        int right = maxPathSumUtil(node.right, result);
        int maxValue = Math.max(node.val, node.val+Math.max(left, right));
        int maxTop = Math.max(maxValue, node.val+left+right);
        result[0] = Math.max(result[0], maxTop);
        return maxValue;
    }
    public int maxPathSum(TreeNode A) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        maxPathSumUtil(A, result);
        return result[0];
    }
}
