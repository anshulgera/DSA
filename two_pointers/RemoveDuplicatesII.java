public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() < 3) return a.size();
        int prev = a.get(1);
        int prev2 = a.get(0);
        int index = 2;
        for(int i=2;i<a.size();i++) {
            if(prev != a.get(i) || prev2 != a.get(i)) {
                a.set(index, a.get(i));
                prev = a.get(i);
                prev2 = a.get(index-1);
                index++;
            }
        }
        return index;
    }
}
