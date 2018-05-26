package basic;

public class EditDistance {

	/*
	 * 

Given two strings str1 and str2 and below operations that can performed on str1. 
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

	a. Insert
	b. Remove
	c. Replace

All of the above operations are of equal cost.

	 */
	public static void main(String[] args) {

		String str1 = "sunday";
		String str2 = "saturday";
		
		char s1[] = str1.toCharArray();
		char s2[] = str2.toCharArray();
		
		int m = s1.length;
		int n = s2.length;
		
		System.out.println(editDistRec(s1, s2, m, n));
		System.out.println(editDistanceDP(s1, s2, m, n));
		
	}
	
	/**
	 * Naive recursive implementation
	 */
	static int editDistRec(char s1[], char s2[], int m, int n) {
		
		if (m==0 && n==0) return 0; //No changes if we reach the end of both strings 
		if (m==0 || n==0) return 1; //if we reach the end of one of the strings, then no. of changes is 1
		
		if (s1[m-1] == s2[n-1]) {
			//if last chars match, then calculate the no. 
			//of operations for the remaining strings
			return editDistRec(s1, s2, m-1, n-1); 
		}
		else {
			return 1 + Math.min(Math.min(editDistRec(s1,s2,m,n-1),  //remove
										editDistRec(s1,s2,m-1,n)),  //insert
										editDistRec(s1,s2,m-1,n-1));//replace
		}
	}
	
	
	/*
	 * Implementation with DP.
	 */
	static int editDistanceDP(char s1[], char s2[], int m, int n) {
		int dp[][] = new int[m+1][n+1];
		
		for (int i=0;i<=m;i++) {
			for (int j=0;j<=n;j++) {
				if (i == 0) {
					dp[i][j] = j;	//if we reach the end of 1 string, then no. of operations is the length of other str
				}
				else if (j == 0) {
					dp[i][j] = i;
				}
				else if (s1[i-1] == s2[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					//if no match, then perform one of the operations on str1 which takes minimum number of changes.
					dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
				}
			}
		}
		
		return dp[m][n];
		
	}

}
