class MergeArrays {
    public void printArray(int[] a, int n) {
        for (int i=0;i<n;i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
        return;
    }
    public void mergeArrays(int[] a, int[] b, int aLength, int bLength) {
        int aIndex = aLength-1;
        int bIndex = bLength-1;
        int endIndex = a.length-1;
        while (aIndex >= 0 && bIndex >=0) {
            if (a[aIndex] > b[bIndex]) {
                a[endIndex] = a[aIndex];
                aIndex--;
            } else {
                a[endIndex] = b[bIndex];
                bIndex--;
            }
            endIndex--;
        }
        // if there are elements left in array B, we need to move them to A
        while (bIndex >= 0) {
            a[endIndex] = b[bIndex];
            bIndex--;
            endIndex--;
        }

        return;
    }
    public static void main(String[] args) {
        MergeArrays m = new MergeArrays();
        int[] a = {1,3,100,0,0,0};
        int[] b = {-1,4,6};
        m.printArray(a, 6);
        m.printArray(b, 3);
        m.mergeArrays(a, b, 3, 3);
        m.printArray(a, 6);
    }
}