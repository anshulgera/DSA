public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int start = 0;
        int end = 0;
        int length = 0;
        int endIndex = 0;
        int count = 0;
        while (end < A.size()) {
            if (A.get(end) == 0) {
                count++;
            }
            while (count > B) {
                if (A.get(start) == 0) count--;
                start++;
            }
            if ((end-start+1) > length) {
                endIndex = end;
                length = end-start+1;
            }
            end++;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=endIndex-length+1;i<=endIndex;i++){
            res.add(i);
        }
        return res;
    }
}
