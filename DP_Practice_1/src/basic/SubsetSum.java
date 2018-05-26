package basic;

import java.util.Arrays;

public class SubsetSum {

/*
 * 

Given a set of non-negative integers, and a value sum, 
determine if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

*/

	
	public static void main(String[] args) {
		int a[] = {3, 34, 4, 12, 5, 2};
		int sum = 12;
		int n = a.length;
		
		boolean hasSubset = hasSubset(a, sum, n);
		String output = hasSubset ? "has subset" : "no subset";
		System.out.println(output);
		
		hasSubset = hasSubsetDP(a, sum, n);
		output = hasSubset ? "has subset" : "no subset";
		System.out.println(output);
	}

	private static boolean hasSubset(int[] a, int sum, int n) {
		
		if (sum == 0) return true;
		if (n==0 && sum != 0) return false;
		
		if (sum < a[n-1]) return hasSubset(a, sum, n-1);
		else {
			return hasSubset(a, sum-a[n-1],n-1) || hasSubset(a, sum, n-1);
		}
	}
	
	//with dp
	private static boolean hasSubsetDP(int[] a, int sum, int n) {
		boolean[][] dp = new boolean[sum+1][n+1];
		
		Arrays.fill(dp[0], true);
		for (int i=1;i<=sum;i++) {
			dp[i][0] = false;
		}
		
		for (int i=0;i<=sum;i++) {
			for (int j=1;j<=n;j++) {
				if (i < a[j-1]) {
					dp[i][j] = dp[i][j-1];
				}
				else {
					dp[i][j] = dp[i-a[j-1]][j-1] || dp[i][j-1];
				}
			}
		}
		
		return dp[sum][n];
	}

}
