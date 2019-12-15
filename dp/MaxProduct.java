public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public int maxProduct(final List<Integer> A) {
        int maxProduct = A.get(0);
        int minProduct = A.get(0);
        int maxSoFar = A.get(0);
        for(int i=1;i<A.size();i++) {
            int a = maxProduct * A.get(i);
            int b = minProduct * A.get(i);
            maxProduct = Math.max(Math.max(a, b), A.get(i));
            minProduct = Math.min(Math.min(a, b), A.get(i));
            maxSoFar = Math.max(maxProduct, maxSoFar);
        }
        return maxSoFar;
    }
}
