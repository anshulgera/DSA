class PrintAllSubstrings {
    
    public static void printSubstrings(String str) {
        int n = str.length();
        // all possible lengths of substring
        for(int len=1;len<n;len++) {
            // all possible starting point for curr length
            for(int i=0;i<=n-len;i++) {
                // ending point for curr starting point and length
                int j=i+len-1;
                for(int k=i;k<=j;k++) {
                    System.out.print(str.charAt(k));
                }
                System.out.println();

            }
        }

    }
    // public static void printSubstringUtil(String str, int i, int j) {
    //     StringBuilder sb = new StringBuilder();
    //     for(int c=i;c<=j;c++) {
    //         sb.append(str.charAt(c));
    //     }
    //     System.out.println(sb.toString());
    // }
    // public static void printSubstring2(String str) {
    //     int n = str.length();
    //     for(int i=0;i<n;i++) {
    //         for(int j=i;j<n;j++) {
    //             printSubstringUtil(str, i, j);
    //         }
    //     }
    // }
    public static void main(String[] args) {
        String s = "1234";
        printSubstring2(s);
    }
}