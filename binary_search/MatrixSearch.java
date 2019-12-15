import java.util.*;

public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int n = a.size();
        int m = a.get(0).size();
        int i = 0;
        int j = m-1;
        while (i <n && j >=0) {
            if ( a.get(i).get(j) == b ) {
                    return 1;
            } else if (a.get(i).get(j) < b) {
                i++;
            } else {
                j--;
            }
        }
        return 0;
    }
}