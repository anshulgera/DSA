public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        int index = 0;
        for(int i=0;i<a.size();i++) {
            if(a.get(i) != b) {
                a.set(index, a.get(i));
                index++;
            }
        }
        return index;
    }
}
