public class AllocateBooks {
    
    public boolean isValid(ArrayList<Integer> A, int B, int curr) {
        if (A.size() < B) return false;
        int students = 1;
        int currPages = 0;
        
        for (int i=0;i<A.size();i++) {
            
            if (currPages+A.get(i) <= curr) {
                currPages += A.get(i);
            } else {
                currPages = A.get(i);
                students++;
                if (students > B) return false;
            }
        }
        return true;
    }
    
    public int books(ArrayList<Integer> A, int B) {
        int sum = 0;
        int minPossible = 0;
        for (int a: A) {
            sum += a;
            minPossible = Math.max(minPossible, a);
        }
        
        int maxPossible = sum;
        int result = -1;
        while (minPossible <= maxPossible) {
            int mid = minPossible + (maxPossible-minPossible)/2;
            
            if ( isValid(A, B, mid) ) {
                result = mid;
                maxPossible = mid-1;
            } else {
                minPossible = mid+1;
            }
        }
        return result;
    }
}
