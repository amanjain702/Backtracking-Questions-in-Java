import java.util.Scanner;

public class Nqueens {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] board = new int[n][n];
		printnQueens(board, n, 0);
	}

	public static void printnQueens(int[][] board, int n, int row) {
		if (row == n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1) {
						System.out.print("Q ");
					} else {
						System.out.print("_ ");
					}
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("*******************************************");
			System.out.println();
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			if (isitSafe(board, row, col)) {
				board[row][col] = 1;
				printnQueens(board, n, row + 1);
				board[row][col] = 0;
			}
		}

	}

	private static boolean isitSafe(int[][] board, int row, int col) {
		int r;
		int c;

		// vertically up
		r = row - 1;
		c = col;
		while (r >= 0) {
			if (board[r][c] == 1)
				return false;
			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == 1)
				return false;
			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c] == 1)
				return false;
			r--;
			c++;
		}
		return true;
	}

	
}
