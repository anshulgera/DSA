public class Solution {
    public int diffPossible(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = 1;
        while (j<A.size()) {
            if (i==j) j++;
            else if (A.get(j)-A.get(i) == B) return 1;
            else if (A.get(j)-A.get(i) > B) i++;
            else j++;
        }
        return 0;
    }
}
