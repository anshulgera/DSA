public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currSum = 0;
        int start = 0;
        int end = 0;
        map.put(0, -1);
        for(int i=0;i<A.size();i++) {
            currSum+= A.get(i);
            if (map.containsKey(currSum)){
                int currStart = map.get(currSum);
                int currEnd = i;
                if(currEnd-currStart+1 > end-start+1){
                    end = currEnd;
                    start = currStart;
                }
            }else {
                map.put(currSum, i);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=start+1;i<=end;i++) {
            res.add(A.get(i));
        }
        return res;
    }
}
