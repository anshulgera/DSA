class Kmp {
    public static void computeLPS(String pattern, int m, int[] lps) {
        // build longest prefix suffix array
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i < m) {
            if(pattern.charAt(len) == pattern.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return;
    }
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = new int[m];
        int i = 0, j = 0;
        
        computeLPS(pattern, m, lps);

        while (i < n) {
            if(pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            } 
            if(j == m) {
                System.out.println("Match found at : " + (i-j));
                System.out.println(text.substring(i-j, i-j+m));
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        return;

    }
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(text, pattern);
    }
}