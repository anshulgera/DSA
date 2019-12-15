public class Solution {
    public int getValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000;
    }
    public int romanToInt(String A) {
        int l = A.length();
        int i = l-2;
        int res = getValue(A.charAt(i+1));
        while (i>=0) {
            if (getValue(A.charAt(i)) < getValue(A.charAt(i+1))) {
               res -= getValue(A.charAt(i));
            } else {
                res += getValue(A.charAt(i));
            }
            i--;
        }
        return res;
    }
}
