public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        if (A.length() == 0) return 0;
        
        String s = A;
        // remove leading and trailing spaces
        s = s.trim();
        
        boolean isNegative = false;
        int startIndex = 0;
        
        if (s.charAt(0) == '+' || s.charAt(0) == '-') startIndex++;
        if (s.charAt(0) == '-') isNegative = true;
        
        long result = 0;
        
        for (int i=startIndex;i<s.length();i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9' ) break;
            int digit = (int) (s.charAt(i)-'0');
            result = result*10 + digit;
            if (result > Integer.MAX_VALUE) break;
        }
        
        if (result > Integer.MAX_VALUE){
            return isNegative?(-1)*Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        if (isNegative) return (-1)*(int)(result);
        return (int)result;
        
        
        
    }
}
