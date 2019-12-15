public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int rows = a.size();
        int cols = a.get(0).size();
        for(int i=0;i<rows;i++) {
            for(int j=i;j<cols;j++) {
                if (i == j) continue;
                int x = a.get(i).get(j);
                int y = a.get(j).get(i);
                a.get(i).set(j, y);
                a.get(j).set(i, x);
            }
            for(int k=0;k<cols/2;k++) {
                int temp = a.get(i).get(k);
                a.get(i).set(k, a.get(i).get(cols-k-1));
                a.get(i).set(cols-k-1, temp);
            }
        }
        return;
    }
}
