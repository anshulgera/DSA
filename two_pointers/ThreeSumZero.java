public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A.size()-2;i++) {
            if(i == 0 || A.get(i) > A.get(i-1)) {
                int start = i+1;
                int end = A.size()-1;
                while(start<end) {
                    int sum = A.get(i) + A.get(start) + A.get(end);
                    if (sum == 0) {
                        ArrayList<Integer> curr = new ArrayList<Integer>();
                        curr.add(A.get(i));
                        curr.add(A.get(start));
                        curr.add(A.get(end));
                        result.add(curr);
                    }
                    if (sum < 0) {
                        int curr = A.get(start);
                        while(curr == A.get(start) && start < end) start++;
                    } else {
                        int curr = A.get(end);
                        while(curr == A.get(end) && start < end) end--;
                    }
                }

            }
        }
        return result;
    }
}
