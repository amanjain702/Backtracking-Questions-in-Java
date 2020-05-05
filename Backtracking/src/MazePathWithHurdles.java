
public class MazePathWithHurdles {

	public static void main(String[] args) {
		int[][]board={{0,0,9,0},{0,0,9,0},{9,0,0,0},{0,9,0,0}};
		MazePathHurdles(board,0,0,3,3);

	}
	public static void MazePathHurdles(int[][] board, int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			board[cr][cc] = 1;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("*******************************************");
			System.out.println();
			return;
		}
	

		if (cr > er || cc > ec) {
			return;
		}

		if (board[cr][cc] == 9) {
			return;
		}
		board[cr][cc] = 1;
		MazePathHurdles(board, cr, cc + 1, er, ec);
		MazePathHurdles(board, cr + 1, cc, er, ec);
		board[cr][cc] = 0;

	}


}
