class Permutations {
    public static String swap(String a, int l, int r) {
        char[] aArray = a.toCharArray();
        char temp = aArray[l];
        aArray[l] = aArray[r];
        aArray[r] = temp;
        return new String(aArray);
    }
    public static void printPermutations(String a, int l, int r){
        if (l == r){
            System.out.println(a);
        } else {
            for(int i=l;i<=r;i++) {
                a = swap(a, l, i);
                printPermutations(a, l+1, r);
                a = swap(a, l, i);
            }
        }
    }
    public static void main(String[] args) {
        String a = "abc";
        printPermutations(a, 0, a.length()-1);
    }
}