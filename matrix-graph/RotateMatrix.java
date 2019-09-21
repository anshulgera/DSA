// to rotate clockwise -> upside down + reverse elements at i,j to j,i 
// to rotate anti-clockwise -> reverse i,j to j,i + upside down

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RotateMatrix {
    
    public void swapMatrix(int[][] matrix, int n) {
        for (int i=0;i<n/2;i++) {
            for (int j=0;j<n/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return;
    }

	public void upsideDownMatrix(int[][] matrix, int n) {

	}
    
	public static void main (String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    int t = scanner.nextInt();
	    while(t--) {
	        int n = scanner.nextInt();
	        int[][] matrix = new int[n][n]; 
	        for (int i=0;i<n;i++) {
	            for (int j=0;j<n;j++) {
	                matrix[i][j] = scanner.nextInt();
	            }
	        }
	        swapMatrix(matrix, n);
			upsideDownMatrix(matrix, n);
	    }
	}
}