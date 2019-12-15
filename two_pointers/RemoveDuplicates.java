public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() == 0) return 0;
        int prev = a.get(0);
        int index = 1;
        for(int i=1;i<a.size();i++) {
            if (prev != a.get(i)) {
                a.set(index, a.get(i));
                index++;
                prev = a.get(i);
            }
        }
        return index;

    }
}
