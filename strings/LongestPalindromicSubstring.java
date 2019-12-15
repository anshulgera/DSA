public class Solution {
    public String expand(String str, int i, int j) {
        while(i>=0 && j<str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        
        return str.substring(i+1, j);
    }
    public String longestPalindrome(String A) {
        if(A.length() < 2) return A;
        String max = "";
        for(int i=0;i<A.length();i++) {
            String x = expand(A, i, i);
            String y = expand(A, i, i+1);
            if (x.length() > max.length()) max = x;
            if (y.length() > max.length()) max = y;
        }
        return max;
    }
}
