public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<A.size();i++) {
            if(map.containsKey(B-A.get(i))) {
                int x = map.get(B-A.get(i));
                int y = i;
                res.add(x+1);
                res.add(y+1);
                return res;
            }
            if(!map.containsKey(A.get(i))) {
                map.put(A.get(i), i);
            }
        }
        return res;
    }
}
