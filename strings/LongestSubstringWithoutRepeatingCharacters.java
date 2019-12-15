class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                // THIS IS IMPORTANT TO MAKE SURE THAT WE DON'T MOVE THE START BACK AGAIN 
                start = Math.max(map.get(endChar)+1, start);
            }
            
            map.put(endChar, end);
            
            end++;
            length = Math.max(length, end-start);
        }
        return length;
        
    }
}

// USING SETS
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int length = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (end < s.length() && start <= end) {
            if(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
                length = Math.max(length, end-start);
            }
        }
        return length;
        
    }
}