import java.util.*;
// Given [3, 30, 34, 5, 9], the largest formed number is 9534330
public class LargestNumber {

    public String largestNumber(final List<Integer> a) {
    
    String[] arr = new String[a.size()];
    for (int i = 0; i < a.size(); i++) {
        arr[i] = String.valueOf(a.get(i));
    }
    
    
    Arrays.sort(arr, new Comparator<String>(){
        public int compare(String a, String b){
            return (b+a).compareTo(a+b);
        }
    });
    
 
    StringBuilder sb = new StringBuilder();
    for(String s: arr){
        sb.append(s);
    }
 
    //check if all zeroes are there
    if(sb.charAt(0) == '0'){     
        return String.valueOf(0);
    }
    
    return sb.toString();   
    }
}