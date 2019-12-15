public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int i = 0;
        int j = A.size()-1;
        int max = 0;
        while (i<j) {
            int cap = (j-i) * Math.min(A.get(i), A.get(j));
            if (cap > max) max = cap;
            if(A.get(i) > A.get(j)) j--;
            else i++;
        }
        return max;
    }
}
