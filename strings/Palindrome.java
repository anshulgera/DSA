// consider only alphanumeric
public class Solution {
    public int isPalindrome(String A) {
        A = A.replaceAll("\\s", "").toLowerCase();
        int startIndex = 0;
        int endIndex = A.length()-1;
        while (startIndex <= endIndex) {
            char a = A.charAt(startIndex);
            char b = A.charAt(endIndex);
            if ((a<'a' || a>'z') && (a<'0' || a>'9')) {
                startIndex++;
            } else if ((b<'a' || b>'z') && (b<'0' || b>'9')) {
                endIndex--;
            } else if (a == b){
                startIndex++;
                endIndex--;
            } else {
                return 0;
            }
        }
        return 1;

    }
}
