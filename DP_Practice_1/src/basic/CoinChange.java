package basic;

import java.util.Arrays;

public class CoinChange {

	/*

Given a value N, if we want to make change for N cents, 
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. 

For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.


	 */
	
	public static void main(String[] args) {
		int n = 4;
		int s[] = {1,2,3};
		int m = s.length;
		System.out.println(count(s, m, n));
	}

	private static int count(int[] s, int m, int n) {

		//array t stores the no. of ways to make change for values 0 ... n
		int t[] = new int[n+1];
		
		//if count(s, m, n) is the number of ways to make change for value 'n' with 'm' coins
		// count(s,m,n) = count(s,m-1,n)       -- Number of ways to make change for value 'n' with 'm-1' coins
//						+ count(s,m,n-s[m])    -- Number of ways to make change for value 'n-s[m]' with m coins
		
		Arrays.fill(t, 0);
		t[0] = 1;		//if the value given is 0, then there is 1 way to make change for 0.
		
		for (int i=0;i<m;i++) {
			for (int j=s[i];j<=n;j++) {
				t[j] = t[j] + t[j-s[i]];
			}
		}
		
		return t[n];
		
	}

}
