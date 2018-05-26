package basic;

import java.util.Arrays;
/*
 Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
For example, if length of the rod is 8 and the values of different pieces are given as following, 
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20


And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

 *
 */
public class CuttingRod {

	public static void main(String[] args) {

		int n = 8; //length of rod
		int[] price = {3,5,8,9,10,17,17,20};

		int maxVal = cutRod(price, n);
		System.out.println(maxVal);
		maxVal = cutRodDP(price, n);
		System.out.println(maxVal);
	}

	private static int cutRod(int[] price, int n) {
		
		if (n <= 0) return 0;
		
		int maxVal = Integer.MIN_VALUE;
		for (int i=0;i<n;i++) {
			maxVal = Math.max(maxVal, price[i] + cutRod(price, n-i-1));
		}
		
		return maxVal;
	}
	
	//using dp
	private static int cutRodDP(int price[], int n) {
		int maxPrice[] = new int[n+1];
		
		Arrays.fill(maxPrice, 0);
		
		for (int i=1;i<=n;i++) {
			for (int j=0;j<i;j++) {
				
				maxPrice[i] = Math.max(maxPrice[i], price[j] + maxPrice[i-j-1]);
			}
		}
		
		return maxPrice[n];
	}

}
