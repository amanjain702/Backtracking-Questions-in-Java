import java.util.Scanner;

public class RookWays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] board = new int[3][3];
		System.out.println(rook_ways(board, 0, 0, 1, 1));

	}

	public static int rook_ways(int[][] board, int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			board[cr][er] = 1;
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int ans = 0;
		for (int moves = 1; moves < board.length; moves++) {
			ans = ans + rook_ways(board, cr, cc + moves, er, ec);
			ans = ans + rook_ways(board, cr + moves, cc, er, ec);
			
		}
		return ans;
	}

}
