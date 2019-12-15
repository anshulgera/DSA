public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int j = 0;
        while (j<A.size() && A.get(j) == 0) {
            A.remove(j);
        }
        int carry = 1;
        for(int i=A.size()-1;i>=0;i--) {
            int sum = A.get(i) + carry;
            A.set(i, sum%10);
            carry = sum/10;
            if (carry == 0) break;
        }
        if (carry != 0) {
            A.add(0, carry);
        }
        return A;
    }
}
