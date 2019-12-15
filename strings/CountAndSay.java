public class Solution {
    public String countAndSay(int A) {
        char prevInt;
        String prevRes = "1";
        int count = 0;
        String currRes = prevRes;
        for(int i=2;i<=A;i++) {
            currRes = "";
            prevInt = prevRes.charAt(0);
            count = 1;
            int end = 1;
            while (end < prevRes.length()) {
                char currChar = prevRes.charAt(end);
                if (prevInt == currChar) {
                    count += 1;
                } else {
                    currRes += Integer.toString(count) + prevInt;
                    count = 1;
                    prevInt = currChar;
                }
                end++;
            }
            if (count != 0) {
                currRes += Integer.toString(count) + prevInt; 
            }
            prevRes = currRes;
        }
        return currRes;
    }
}
