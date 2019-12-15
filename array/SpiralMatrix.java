// [1]
// [2]
// [3]
// this fails for simple->
//  while {
//  for top
//  for right
//  for bottom
//  for left
// }
// handle direction as well and enclose steps in direction check block
// update direction after completion of one level
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int n = A.size()-1;
        int m = A.get(0).size()-1;
        int direction = 0;
        while(i<=n && j<=m) {
            if(direction == 0){
                for(int x=j;x<=m;x++) {
                    res.add(A.get(i).get(x));
                }
                i++;
                direction = 1;
            }
            else if (direction == 1) {
                for(int x=i;x<=n;x++) {
                    res.add(A.get(x).get(m));
                }
                m--;
                direction = 2;
            }
            else if(direction == 2){
                for(int x=m;x>=j;x--) {
                res.add(A.get(n).get(x));
                }
                n--;
                direction = 3;
            }
            else if (direction == 3) {
                for(int x=n;x>=i;x--) {
                    res.add(A.get(x).get(j));
                }
                j++;
                direction = 0;
            }
        }
        return res;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ex = new ArrayList<>();
        for(int i=0;i<A;i++) {
            ex.add(0);
        }
        for(int i=0;i<A;i++) {
            res.add(new ArrayList<>(ex));
        }
        int i = 0;
        int j = 0;
        int n = A-1;
        int m = A-1;
        int count = 1;
        while (i<=n && j<=m) {
            // first row
            for(int x=j;x<=m;x++) {
                res.get(i).set(x, count);
                count++;
            }
            i++;
            // last col
            for(int x=i;x<=n;x++) {
                res.get(x).set(m, count);
                count++;
            }
            m--;
            // last row
            for(int x=m;x>=j;x--) {
                res.get(n).set(x, count);
                count++;
            }
            n--;
            // first col
            for(int x=n;x>=i;x--) {
                res.get(x).set(j, count);
                count++;
            }
            j++;
        }
        return res;
    }
}
