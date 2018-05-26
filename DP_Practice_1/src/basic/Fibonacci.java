package basic;

public class Fibonacci {

	public static void main(String[] args) {
		
		int n = 8;
		int dp[] = new int[n];
		for (int i=0;i<n;i++) {
			dp[i] = -1;
		}
		int fibo = fibonacci(n-1, dp);
		System.out.println(fibo);
		
		for (int i : dp) {
			System.out.print(i + " ");
		}

	}

	private static int fibonacci(int n, int[] dp) {
		
		int fibon = 0;
		if (n == 0) {
			dp[n] = 0;
			fibon = 0;
		}
		else if (n == 1) {
			dp[n] = 1;
			fibon = 1;
		}
		else {
			int a = (dp[n-1] == -1) ? fibonacci(n-1, dp) : dp[n-1];
			int b = (dp[n-2] == -1) ? fibonacci(n-2, dp) : dp[n-2];
			fibon = a + b;
			dp[n] = fibon;
		}
		return fibon;
		
	}

}
