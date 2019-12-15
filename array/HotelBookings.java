// keep count of number of rooms required at every start and end time possible
// whenever count > no of rooms available, then it is not possible
// using 2 pointers
// another way to use minheap 
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int n = depart.size();
        int rooms = 1;
        int i = 1;
        int j = 0;
        while (i<n && j<n) {
            if(arrive.get(i) < depart.get(j)) {
                rooms++;
                if(rooms > K) return false;
                i++;
            } else {
                rooms--;
                j++;
            }
        } 

        return true;
    }
}
