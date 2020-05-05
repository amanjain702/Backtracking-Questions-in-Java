
public class Sudoku_Solver {

	public static void main(String[] args) {
		int[][] board = { 
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
				};
		int n = 9;
		boolean[][] fixedcells = new boolean[n][n];
		setfixedcells(board, fixedcells, n);
		boolean ans = sudukosolver(board, fixedcells, 0, 0, n);
		if (ans) {
			printBoard(board);
		} else {
			System.out.println("Can't solve");
		}

	}

	public static boolean sudukosolver(int[][] board, boolean[][] fixedcells, int row, int col, int n) {
		if (row == n) {
			return true;
		}
		if (col == n) {
			return sudukosolver(board, fixedcells, row + 1, 0, n);
		}
		if (fixedcells[row][col]) {
			return sudukosolver(board, fixedcells, row, col + 1, n);
		}

		for (int num = 1; num <= n; num++) {
			boolean canplace = canPlace(board, row, col, n, num);
			if (canplace) {
				board[row][col] = num;
				boolean solverest = sudukosolver(board, fixedcells, row, col + 1, n);
				if (solverest) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static boolean canPlace(int[][] board, int row, int col, int n, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num) {
				return false;
			}
			if (board[i][col] == num) {
				return false;
			}
		}
		int sqrtN = (int) Math.sqrt(n);
		int startrow = (row / sqrtN) * sqrtN;
		int startcol = (col / sqrtN) * sqrtN;
		for (int i = startrow; i < startrow + sqrtN; i++) {
			for (int j = startcol; j < startcol + sqrtN; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static void setfixedcells(int[][] board, boolean[][] fixedcells, int n) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					fixedcells[i][j] = true;
				} else {
					fixedcells[i][j] = false;
				}
			}
		}

	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();

		}
	}

}
