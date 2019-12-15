public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int start = 0;
        int end = a.size() - 1;
        int result = 0;
        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if(a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) > b) {
                result = mid;
                end = mid-1;
            } else {
                result = mid+1;
                start = mid+1;
            }
        }
        return result;
    }
}
