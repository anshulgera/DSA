public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i=0;
        int j=0;
        int k=0;
        int p = A.size();
        int q = B.size();
        int r = C.size();
        int res = Integer.MAX_VALUE;
        while (i<p && j<q && k<r) {
            int max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int diff = Math.abs(max-min);
            if (diff < res) {
                res = diff;
            }
            if (A.get(i) == min) i++;
            else if (B.get(j) == min) j++;
            else k++;
        }
        return res;
    }
}
