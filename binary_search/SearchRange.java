import java.util.*;

public class SearchRange {
    public int findIndex(final List<Integer> a, int b, boolean findFirst) {
        int n = a.size();
        int start = 0;
        int end = n-1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if (a.get(mid) == b) {
                result = mid;
                if (findFirst) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else if (a.get(mid) > b) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
    
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int first = findIndex(a, b, true);
        int last = findIndex(a, b, false);
        return new ArrayList<Integer>(Arrays.asList(first, last));
    }
}
