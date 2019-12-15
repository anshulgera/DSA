import java.util.*;

class Permutations {
    public static void permuteUtil(String res, HashMap<Character,Integer> map, int len) {
        if(res.length() == len) {
            // System.out.println("result : " + res);   
            System.out.println(res);
            return;
        }
        for(char c:map.keySet()) {
            // System.out.println(c);
            if (map.get(c) == 0) continue;
            res += c;
            // System.out.println("before " + res);
            map.put(c, map.get(c)-1);
            permuteUtil(res, map, len);
            map.put(c, map.get(c)+1);
            res = res.substring(0, res.length()-1);
            // System.out.println("after " + res);
        }
    }
    public static void permute(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        permuteUtil("", map, str.length());

    }
    public static void main(String[] args) {
        String a = "4321";
        permute(a);
    }
}