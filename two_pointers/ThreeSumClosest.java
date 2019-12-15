public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int minDiff = Integer.MAX_VALUE;
        int resi = 0;
        int resj = 0;
        int resk = 0;
        
        for(int i=0;i<A.size()-2;i++) {
            int start = i+1;
            int end = A.size()-1;
            while (start < end) {
                int sum = A.get(i) + A.get(start) + A.get(end);
                if (Math.abs(sum-B) < minDiff) {
                    minDiff = Math.abs(sum-B);
                    resi = i;
                    resj = start;
                    resk = end;
                }
                if (sum - B == 0) {
                    return sum;
                } else if (sum-B < 0){
                    start++;
                } else {
                    end--;
                }
            }
        }
        return A.get(resi) + A.get(resj) + A.get(resk);
    }
}
