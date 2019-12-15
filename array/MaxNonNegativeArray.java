public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        long maxSum = -1;
        long currSum = 0;
        for(Integer i:A) {
            if (i>=0) {
                curr.add(i);
                currSum += i;
            } else {
                currSum = 0;
                curr = new ArrayList<Integer>();
            }
            if (currSum >maxSum || (maxSum == currSum && curr.size() > res.size())) {
                maxSum = currSum;
                res = curr;
            }
        }
        return res;
    }
}
