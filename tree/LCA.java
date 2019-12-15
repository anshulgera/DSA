// nodes may or may not exists in tree
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
    public boolean getPath(TreeNode A, int x, ArrayList<Integer> path) {
        if(A == null) return false;
        path.add(A.val);
        if(A.val == x) return true;
        if((A.left != null && getPath(A.left, x, path)) || (A.right !=null && getPath(A.right, x, path))) return true;
        path.remove(path.size()-1);
        return false;
    }
    public int intersection(ArrayList<Integer> path1, ArrayList<Integer> path2) {
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if(!path1.get(i).equals(path2.get(i))){
                break;
            }
            i++;
        }
        return path1.get(i-1);
    }
    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        boolean BExists = getPath(A, B, path1);
        boolean CExists = getPath(A, C, path2);
        if(!BExists || !CExists) return -1;
        int res = intersection(path1, path2);
        return res;
        
    }
}
