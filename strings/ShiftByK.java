class ShiftByK {
    public static void shiftByK(String x, int k) {
        // Creating new string
        // shift left
        String y = x.substring(k) + x.substring(0, k);
        System.out.println(y);
    }
    public static void shiftByKStringBuffer(String x, int k) {
        // using char array
        StringBuffer a = new StringBuffer(x);
        int n = x.length();
        // shift left
        char[] b = new char[n];
        for(int i=0;i<n;i++) {
            b[i] = a.charAt((i+k)%n);
        }
        System.out.println("Shift left ->" + new String(b));
        // shift right
        char[] c = new char[n];
        for(int i=0;i<n;i++) {
            c[i] = a.charAt((n-k+i)%n);
        }
        System.out.println("Shift right ->" + new String(c));
    }

    public static void main(String[] args) {
        // shiftByK("shift_string", 2);
        shiftByKStringBuffer("FullName", 2);
    }
}