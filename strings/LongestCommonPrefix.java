public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        String prefix = "";
        int maxLength = Integer.MAX_VALUE;
        // find length of smallest string which can be max prefix length
        for(int i=0;i<A.size();i++) {
            if (A.get(i).length() < maxLength ){
                maxLength = A.get(i).length();
            }
        }
        for(int i=0;i<maxLength;i++) {
            char curr = A.get(0).charAt(i);
            for(int j=1;j<A.size();j++) {
                if (curr != A.get(j).charAt(i)) {
                    return prefix;
                }
            }
            prefix += curr;
        }
        return prefix;
    }
}
