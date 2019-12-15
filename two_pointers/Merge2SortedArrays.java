public class Solution {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = a.size()-1;
        int j = b.size()-1;
        while (i>=0 && j>=0) {
            if(b.get(j) > a.get(i)) {
                a.add(i+1, b.get(j));
                j--;
            } else {
                i--;
            }
        }
        while(j>=0) {
            a.add(0, b.get(j));
            j--;
        }
        return;
        
    }
}
