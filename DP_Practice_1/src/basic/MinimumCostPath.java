package basic;

import java.util.Scanner;

public class MinimumCostPath {

	/*
	 * 
3 3 
1 2 3
4 8 2
1 5 3

	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		int a[][] = new int[r][c];
		
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int cost[][] = new int[r+1][c+1];
		
		System.out.println(minCost(a,cost,r,c));
		sc.close();
	}

	private static int minCost(int[][] a, int[][] cost, int r, int c) {

		for (int i=0;i<r;i++) {
			cost[i][0] = a[i][0];
		}
		for (int i=0;i<c;i++) {
			cost[0][i] = a[0][i];
		}
		for (int i=1;i<=r;i++) {
			for (int j=1;j<=c;j++) {
				cost[i][j] = Math.min(Math.min(cost[i-1][j], 
											   cost[i][j-1]), 
											   cost[i-1][j-1]) + a[i-1][j-1];
			}
		}
		
		return cost[r][c];
		
	}

}
