public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(i<A.size() && j<B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                res.add(A.get(i));
                i++;
                j++;
            }
        }
        return res;
    }
}
