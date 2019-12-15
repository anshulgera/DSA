// 1. from right to left, find first decreasing element ex -> 2,3,4,6,1,0 here 4 is such number
// if on such number exists, then current permutation is the last lexicographically possible so return reverse
// 2. from right to left, find first number greater than the number found eariler
// 3. swap those numbers
// 4. reverse number found after the number found on step 2
// 
class NextPermutation {
    public static void permute(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer(s);
        int firstSmaller = -1;
        for(int i=n-1;i>0;i--) {
            if(s.charAt(i) > s.charAt(i-1)) {
                firstSmaller = i;
                break; 
            }
        }

        if (firstSmaller == -1) {
            // current permutation is last possible as whole string characters are in descending order
            System.out.println(sb.reverse());
            return;
        }

        int firstLarger = -1;
        for(int i=n-1;i>firstSmaller;i--) {
            if(s.charAt(firstSmaller) < s.charAt(i)){
                firstLarger = i;
                break;
            }
        }
        char temp = s.charAt(firstSmaller);
        sb.setCharAt(firstSmaller, s.charAt(firstLarger));
        sb.setCharAt(firstLarger, temp);
        
        int count = 0;
        for(int i=firstLarger+1;i<(n-firstLarger)/2;i++) {
            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(n-count));
            sb.setCharAt(n-count, t);
            count++;
        }
        System.out.println(sb.toString());


    }
    public static void main(String[] args) {
        String s = "123";
        permute(s);
    }
}