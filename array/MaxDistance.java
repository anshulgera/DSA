public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int maxDistance = 0;
        int n = A.size();
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        leftMin[0] = A.get(0);
        for(int i=1;i<n;i++) {
            leftMin[i] = Math.min(A.get(i), leftMin[i-1]);
        }
        rightMax[n-1] = A.get(n-1);
        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], A.get(i));
        }
        
        int i = 0;
        int j = 0;
        while (i<n && j<n) {
            if(leftMin[i] <= rightMax[j]) {
                maxDistance = Math.max(maxDistance, j-i);
                j++;
            } else {
                i++;
            }
        }
        return maxDistance;
    }
        
}
    