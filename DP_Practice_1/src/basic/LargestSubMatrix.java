package basic;

import java.util.Scanner;

public class LargestSubMatrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int m[][] = new int[r][c];
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				m[i][j] = sc.nextInt();
			}
		}
		largestSubMatrix(m, r, c);
		
		sc.close();
	}
	
	static void largestSubMatrix(int m[][], int r, int c) {
		int s[][] = new int[r+1][c+1];
		
		for (int i=0;i<r;i++) {
			s[i][0] = m[i][0];
		}
		for (int i=0;i<c;i++) {
			s[0][i] = m[0][i];
		}
		//build s matrix
		for (int i=1;i<r;i++) {
			for (int j=1;j<c;j++) {
				/*if (i==0 && j>0) {
					s[i][j] = m[i][j-1];
				}
				if (i>0 && j==0) {
					s[i][j] = m[i-1][j-1];
				}*/
				
				if (m[i][j] == 1) {
					s[i][j] = Math.min(Math.min(s[i-1][j], s[i][j-1]), s[i-1][j-1]) + 1;
				}
				else {
					s[i][j] = 0;
				}
			}
		}
		
		int maxR = 0;
		int maxC = 0;
		int max = s[0][0];
		
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if (s[i][j] > max) {
					max = s[i][j];
					maxR = i;
					maxC = j;
				}
			}
		}
		
		//print sub matrix
/*		for (int i=maxR-max;i<maxR;i++) {
			for (int j=maxC-max;j<maxC;j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
*/		
		for (int i=maxR;i>maxR - max;i--) {
			for (int j=maxC;j>maxC - max;j--) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
