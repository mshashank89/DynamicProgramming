package basic;

public class LongestCommonSubSequence {

	public static void main(String[] args) {

		String a = "ABCDGH";
		String b = "AEDFHR";
		
		char[] x = a.toCharArray();
		char y[] = b.toCharArray();
		int m = x.length;
		int n = y.length;
		System.out.println(lcs(x,y,m,n));
		System.out.println(lcsdp(x,y,m,n));
	}
	
	static int lcs(char x[], char y[], int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (x[m-1] == y[n-1]) {
			return 1 + lcs(x, y, m-1, n-1);
		}
		else {
			return Math.max(lcs(x,y,m-1,n), lcs(x,y,m,n-1));
		}
	}

	//using DP
	//use a 2d matrix to store the lcs till that point
	
	static int lcsdp(char x[], char y[], int m, int n) {
		int l[][] = new int[m+1][n+1];
		
		//build the matrix from bottom-up
		for (int i=0;i<=m;i++) {
			for (int j=0;j<=n;j++) {
				if (i==0 || j==0) {
					l[i][j] = 0;
				}
				else if (x[i-1] == y[j-1]) {
					l[i][j] = l[i-1][j-1] + 1;
				}
				else {
					l[i][j] = Math.max(l[i][j-1], l[i-1][j]);
				}
			}
		}
		
		return l[m][n];
	}
}
