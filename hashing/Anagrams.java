public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public void fillHashMap(HashMap<Character, Integer> map, String str) {
        for(int i=0;i<str.length();i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return;
    }
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        boolean[] visited = new boolean[A.size()];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A.size();i++) {
            if(visited[i]) continue;
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(i+1);
            HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
            fillHashMap(map1, A.get(i));
            for(int j=i+1;j<A.size();j++) {
                if(visited[j]) continue;
                HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
                fillHashMap(map2, A.get(j));
                if (map1.equals(map2)) {
                    curr.add(j+1);
                    visited[j] = true;
                }
            }
            visited[i] = true;
            ans.add(curr);
        }
        return ans;
    }
}
