package basic;

public class WaysToFormANumberFromSum {
	
	static int n = 6;
	static int dp[] = new int[n+1];

	public static void main(String[] args) {
		
		for (int i=0;i<dp.length;i++) {
			dp[i] = -1;
		}
		System.out.println(solve(n));

	}
	
	private static int solve(int n) {
		if (n < 0) return 0;
		if (n == 0) {
			dp[n] = 1;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		dp[n] = solve(n-1) + solve(n-3) + solve(n-5);
		
		return dp[n];
	}

}
