public class Solution {
	public String reverseWords(String a) {
	    String[] words = a.split(" ");
	    StringBuilder stringBuilder = new StringBuilder();
	    for(int i = words.length - 1; i >= 0; i--) {
            // trim removes all leading and trailing spaces and then returns the string
	        stringBuilder.append(words[i].trim());
	        
	        if(i != 0) {
	            stringBuilder.append(" ");
	        }
	    }
	    return stringBuilder.toString();
	}
}