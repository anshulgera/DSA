class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s1.length();i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        int start = 0;
        int end = 0;
        int count = map.size();
        while (end < s2.length() && start <= end) {
            if (map.containsKey(s2.charAt(end))) {
                map.put(s2.charAt(end), map.get(s2.charAt(end)) - 1);
                if (map.get(s2.charAt(end)) == 0) count--;
            }
            end++;
            while(count == 0) {
                if (s1.length() == end-start) return true;
                if (map.containsKey(s2.charAt(start))) {
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    if (map.get(s2.charAt(start)) > 0) count++;
                }
                start++;
            }
        }
        return false;
    }
}