class WaterBetweenWalls {
    public static void water(int[] arr) {
        int water = 0;
        int n = arr.length;
        for(int i=1;i<n;i++) {
            int cap = 0;
            // left
            int leftMax = 0;
            for(int j=i-1;j>=0;j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            // right
            int rightMax = 0;
            for(int k=i;k<n;k++) {
                rightMax = Math.max(rightMax, arr[k]);
            }
            cap = Math.min(rightMax, leftMax);
            System.out.print(cap + " ");
            water += cap;
        }
        System.out.println("Total Cap : " + water);

    }
    public static void water2(int[] arr) {
        int n = arr.length;
        int water = 0;
        
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for(int i=1;i<n;i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }
        
        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]); 
        }

        for(int i=0;i<n-1;i++) {
            int cap = 0;
            int left = leftMax[i];
            int right = rightMax[i+1];
            cap = Math.min(left, right);
            water += cap;
        }
        System.out.println("DP : " + water);
    }
    public static void main(String[] args) {
        int[] arr = {10, 1, 3, 2, 5, 1};
        int[] arr1 = {1, 3, 2, 5, 1};
        // n^2
        water(arr);
        water2(arr); 
        water(arr1);
        water2(arr1);
    }
}