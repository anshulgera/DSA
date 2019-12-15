class Solution {
    public String minWindow(String s, String t) {
        
        if (t.length() > s.length() || s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // Create hashmap storing frequency of chars in substring
        for(int i=0;i<t.length();i++) {
            char curr = t.charAt(i);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr)+1);
            } else {
                map.put(curr, 1);
            }
        }
        
        // number of unique chars in substring
        int count = map.size();
        
        int start = 0;
        int end = 0;
        
        // current length of min window
        int length = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar)-1);
                if (map.get(endChar) == 0) count --;
            }
            end++;
            
            while (count == 0) {
                if (length > (end-start)) {
                    length = end-start;
                    minStart = start;
                }
                
                char startChar = s.charAt(start);
                
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) count++;
                    map.put(startChar, map.get(startChar)+1);
                }
                start++;
            } 
        }
        if (length > s.length()) return "";
        
        
        return s.substring(minStart, minStart+length);
        
    }
}