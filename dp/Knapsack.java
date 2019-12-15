/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Knapsack {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k=0;k<t;k++) {
		    int n = sc.nextInt();
		    int W = sc.nextInt();
		    int[] val = new int[n];
		    int[] wt = new int[n];
		    for(int i=0;i<n;i++) val[i] = sc.nextInt();
		    for(int i=0;i<n;i++) wt[i] = sc.nextInt();
		    int[][] memo = new int[n+1][W+1];
		    
		    for(int i=0;i<n+1;i++) {
		        for(int w=0;w<W+1;w++) {
		            if(i == 0 || w == 0) memo[i][w] = 0;
		            else if(wt[i-1] > w) memo[i][w] = memo[i-1][w];
		            else {
		                memo[i][w] = Math.max(val[i-1] + memo[i-1][w-wt[i-1]], memo[i-1][w]);
		            }
		        }
		    }
		    System.out.println(memo[n][W]);
		    
		}
	}
}