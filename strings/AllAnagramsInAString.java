class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<p.length();i++) {
            char curr = p.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        int start = 0;
        int end = 0;
        int count = map.size();
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if(map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar)-1);
                if (map.get(endChar) == 0) count--;
            }
            end++;
            
            while (count == 0) {
                
                if (end-start == p.length()) {
                    res.add(start);
                }
                
                char startChar = s.charAt(start);
                if(map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar)+1);
                    if (map.get(startChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }
        
        return res;
        
    }
}