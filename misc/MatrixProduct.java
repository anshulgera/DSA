class MatrixProduct{
    // from top left to bottom right path with max product.
    // if matrix consists of only positives,
    // we can just keep track of max of subproblems
    // otherwise, we need both max and min subproblems
    // as the negatives may or may not cancel eachother
    public void matrixProduct(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[][] maxProduct = new int[rowCount][colCount];
        int[][] minProduct = new int[rowCount][colCount];

        maxProduct[0][0] = matrix[0][0];
        minProduct[0][0] = matrix[0][0];

        // for 0th column
        for (int i=1;i<rowCount;i++) {
            minProduct[i][0] = matrix[i][0] * minProduct[i-1][0];
            maxProduct[i][0] = matrix[i][0] * maxProduct[i-1][0];
        }

        // for 0th row
        for (int j=1;j<colCount;j++) {
            minProduct[0][j] = matrix[0][j] * minProduct[0][j-1];
            maxProduct[0][j] = matrix[0][j] * maxProduct[0][j-1];
        }


        for(int i=1;i<rowCount;i++) {
            for(int j=1;j<colCount;j++) {
                int maxUp = Math.max(matrix[i][j] * maxProduct[i-1][j], matrix[i][j] * minProduct[i-1][j]);
                int maxLeft = Math.max(matrix[i][j] * maxProduct[i][j-1], matrix[i][j] * minProduct[i][j-1]);
                int minUp = Math.min(matrix[i][j] * maxProduct[i-1][j], matrix[i][j] * minProduct[i-1][j]);
                int minLeft = Math.min(matrix[i][j] * maxProduct[i][j-1], matrix[i][j] * minProduct[i][j-1]);
                maxProduct[i][j] = Math.max(maxLeft, maxUp);
                minProduct[i][j] = Math.min(minLeft, minUp);
            }
        }
        System.out.println(maxProduct[rowCount-1][colCount-1]);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                           {7,8,9}};
        MatrixProduct m = new MatrixProduct();
        m.matrixProduct(matrix);
        int[][] matrix2 = {{-1,2,3},
                            {4,5,-6},
                            {7,8,9}};
        m.matrixProduct(matrix2);
    }
}